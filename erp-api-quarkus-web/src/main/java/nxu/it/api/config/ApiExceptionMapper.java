package nxu.it.api.config;

import nxu.it.api.common.result.ResponseType;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static nxu.it.api.common.result.ApiResult.fail;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        Response.Status status;
        ResponseType responseType;
        if (exception instanceof NotFoundException) {
            status = Response.Status.NOT_FOUND;
            responseType = ResponseType.NOT_FOUND;
        } else if (exception instanceof NotAuthorizedException) {
            status = Response.Status.UNAUTHORIZED;
            responseType = ResponseType.UNAUTHORIZED;
        } else {
            status = Response.Status.BAD_REQUEST;
            responseType = ResponseType.BAD_REQUEST;
        }
        return Response.status(status)
                .entity(fail(responseType).setMessage(exception.getMessage()))
                .build();

    }
}
