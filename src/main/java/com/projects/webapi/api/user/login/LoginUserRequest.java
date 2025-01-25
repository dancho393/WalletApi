package com.projects.webapi.api.user.login;

import com.projects.webapi.api.base.OperationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest implements OperationRequest {
     private String username;
    private String password;
}

