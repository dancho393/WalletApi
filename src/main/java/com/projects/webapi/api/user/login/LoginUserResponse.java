package com.projects.webapi.api.user.login;

import com.projects.webapi.api.base.OperationResponse;

public record LoginUserResponse(
        String jwtToken
) implements OperationResponse {
}
