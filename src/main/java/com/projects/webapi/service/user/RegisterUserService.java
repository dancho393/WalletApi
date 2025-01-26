package com.projects.webapi.service.user;

import com.projects.webapi.api.user.register.RegisterUserDTO;
import com.projects.webapi.api.user.register.RegisterUserOperation;
import com.projects.webapi.api.user.register.RegisterUserRequest;
import com.projects.webapi.api.user.register.RegisterUserResponse;
import com.projects.webapi.exception.UsernameAlreadyExists;
import com.projects.webapi.model.User;
import com.projects.webapi.model.enums.Role;
import com.projects.webapi.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserOperation {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public RegisterUserResponse execute(RegisterUserRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExists("Sorry But This Username Already Exists");
        }
            User user = buildUser(request);
            User savedUser = userRepository.save(user);
            return buildResponse(savedUser);

    }
    private User buildUser(RegisterUserRequest request){
        return User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .build();
    }
    private RegisterUserResponse buildResponse(User user){
        RegisterUserDTO userDTO =
                RegisterUserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .role(user.getRole().toString())
                        .build();
        return  new RegisterUserResponse(userDTO);
    }
}
