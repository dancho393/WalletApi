package com.projects.webapi.api.user.login;

import com.projects.webapi.api.base.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse implements OperationResponse {
    private String jwtToken;
}
