package com.projects.webapi.api.user.register;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserDTO {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String role;
}
