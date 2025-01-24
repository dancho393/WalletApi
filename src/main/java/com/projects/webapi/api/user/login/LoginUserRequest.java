package com.projects.webapi.api.user.login;

import com.projects.webapi.api.base.OperationRequest;

public record LoginUserRequest(
        String username,
        String password
) implements OperationRequest {

}

