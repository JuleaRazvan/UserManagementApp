package com.RJulea.UserManagementApp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.RJulea.UserManagementApp.dto.UserDTO;
import com.RJulea.UserManagementApp.entities.User;
import com.RJulea.UserManagementApp.mappers.UserMapper;
import com.RJulea.UserManagementApp.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.mapEntityToDTO(user))
                .toList();
    }

    public UserDTO getUserByPublicIdentifier(UUID publicIdentifier) {
        User foundUser = userRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return userMapper.mapEntityToDTO(foundUser);
    }

    public UserDTO updateUser(UserDTO userDTO, UUID publicIdentifier) {
        User updatedUser = userRepository.findByPublicIdentifierMandatory(publicIdentifier);

        updatedUser.setFirstname(userDTO.getFirstname());
        updatedUser.setLastname(userDTO.getLastname());
        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setRole(userDTO.getRole());
        updatedUser = userRepository.save(updatedUser);

        return userMapper.mapEntityToDTO(updatedUser);
    }

    @Transactional
    public void deleteUserByPublicIdentifier(UUID publicIdentifier) {
        userRepository.deleteByPublicIdentifier(publicIdentifier);
    }
}
