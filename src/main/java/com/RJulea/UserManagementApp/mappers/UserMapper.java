package com.RJulea.UserManagementApp.mappers;

import org.springframework.stereotype.Component;
import com.RJulea.UserManagementApp.dto.UserDTO;
import com.RJulea.UserManagementApp.entities.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper {

    public UserDTO mapEntityToDTO(User user) {
        return UserDTO.builder()
                .publicIdentifier(user.getPublicIdentifier())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
