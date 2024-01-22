package nxu.it.api.config;

import nxu.it.api.common.result.ApiResult;
import nxu.it.api.common.result.ResponseType;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidateErrorMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ApiResult.fail(ResponseType.BAD_REQUEST).setMessage(exception.getMessage()))
                .build();
    }
}
