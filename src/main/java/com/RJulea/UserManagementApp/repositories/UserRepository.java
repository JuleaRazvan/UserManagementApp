package com.RJulea.UserManagementApp.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.RJulea.UserManagementApp.entities.User;

@Repository
public interface UserRepository extends PubliclyIdentifiableRepository<User> {

    Optional<User> findByEmail(String email);
    
    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
