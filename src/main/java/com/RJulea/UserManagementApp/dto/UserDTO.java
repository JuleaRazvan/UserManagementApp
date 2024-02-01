package com.RJulea.UserManagementApp.dto;

import java.util.UUID;
import com.RJulea.UserManagementApp.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDTO {
    private UUID publicIdentifier;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
