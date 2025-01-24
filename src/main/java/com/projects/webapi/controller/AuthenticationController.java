package com.projects.webapi.controller;

import com.projects.webapi.api.user.login.LoginUserOperation;
import com.projects.webapi.api.user.login.LoginUserRequest;
import com.projects.webapi.api.user.login.LoginUserResponse;
import com.projects.webapi.api.user.register.RegisterUserOperation;
import com.projects.webapi.api.user.register.RegisterUserRequest;
import com.projects.webapi.api.user.register.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final LoginUserOperation loginUserOperation;
    private final RegisterUserOperation registerUserOperation;
    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> login(
            @RequestBody LoginUserRequest request){
        return ResponseEntity.ok(loginUserOperation.execute(request));
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(
            @RequestBody RegisterUserRequest request){
        return ResponseEntity.ok(registerUserOperation.execute(request));
    }
}
