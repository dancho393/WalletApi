package com.projects.webapi.service.user;

import com.projects.webapi.api.user.register.RegisterUserDTO;
import com.projects.webapi.api.user.register.RegisterUserOperation;
import com.projects.webapi.api.user.register.RegisterUserRequest;
import com.projects.webapi.api.user.register.RegisterUserResponse;
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
            User user = buildUser(request);
            User savedUser = userRepository.save(user);
            return buildResponse(user);

    }
    private User buildUser(RegisterUserRequest request){
        return User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .firstName(request.firstName())
                .lastName(request.lastName())
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
