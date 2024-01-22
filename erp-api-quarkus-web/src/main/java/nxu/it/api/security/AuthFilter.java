package nxu.it.api.security;

import io.quarkus.arc.Priority;
import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

//@PreMatching
@Priority(value = Priorities.AUTHENTICATION)
@Provider

public class AuthFilter implements ContainerRequestFilter {
    @Context
    ResourceInfo resourceInfo;

    @Inject
    TokenService tokenService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method resourceMethod = resourceInfo.getResourceMethod();
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        Annotation[] annotations = resourceMethod.getAnnotations();
        boolean needAuthenticate = Arrays.stream(annotations)
                .filter(Authenticated.class::isInstance).count() > 0;

        List<String> tokenList = headers.get("token");
        NotAuthorizedException notAuthorizedException = new NotAuthorizedException("未授权", Response.status(Response.Status.UNAUTHORIZED).build());
        if (needAuthenticate) {
            if (!tokenService.isValid(tokenList.get(0))) {
                throw notAuthorizedException;
            } else {
                requestContext.setSecurityContext(new SecurityContext() {
                    @Override
                    public Principal getUserPrincipal() {
                        return new Principal() {
                            @Override
                            public String getName() {
                                return tokenService.getUserName(tokenList.get(0)).orElseThrow(() -> notAuthorizedException);
                            }
                        };
                    }

                    @Override
                    public boolean isUserInRole(String role) {
                        return tokenService.getRoles(tokenList.get(0))
                                .contains(role);
                    }

                    @Override
                    public boolean isSecure() {
                        return false;
                    }

                    @Override
                    public String getAuthenticationScheme() {
                        return BASIC_AUTH;
                    }
                });
            }
        }

    }

}
