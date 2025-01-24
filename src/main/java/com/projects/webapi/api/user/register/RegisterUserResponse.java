package com.projects.webapi.api.user.register;

import com.projects.webapi.api.base.OperationResponse;

public record RegisterUserResponse(
        RegisterUserDTO user
) implements OperationResponse {

}
