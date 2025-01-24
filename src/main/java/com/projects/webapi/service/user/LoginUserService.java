package com.projects.webapi.service.user;


import com.projects.webapi.api.user.login.LoginUserOperation;
import com.projects.webapi.api.user.login.LoginUserRequest;
import com.projects.webapi.api.user.login.LoginUserResponse;
import com.projects.webapi.exception.EntityNotFoundException;
import com.projects.webapi.repo.UserRepository;
import com.projects.webapi.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserService implements LoginUserOperation {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public LoginUserResponse execute(LoginUserRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        var user = userRepository.findByUsername(request.username())
                .orElseThrow(()->new EntityNotFoundException("User Not Found"));
        var jwtToken =jwtService.generateToken(user);

        return new LoginUserResponse(jwtToken);
    }
}
