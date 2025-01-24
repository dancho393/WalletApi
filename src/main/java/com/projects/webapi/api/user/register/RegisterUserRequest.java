package com.projects.webapi.api.user.register;

import com.projects.webapi.api.base.OperationRequest;

public record RegisterUserRequest(
        String username,
        String password,
        String firstName,
        String lastName
) implements OperationRequest {
}
