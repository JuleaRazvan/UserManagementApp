package com.RJulea.UserManagementApp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RJulea.UserManagementApp.dto.UserDTO;
import com.RJulea.UserManagementApp.services.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{publicIdentifier}")
    public UserDTO getUserByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return userService.getUserByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public UserDTO editUser(@RequestBody UserDTO userDTO, @PathVariable UUID publicIdentifier) {
        return userService.updateUser(userDTO, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier) {
        userService.deleteUserByPublicIdentifier(publicIdentifier);
    }
}
