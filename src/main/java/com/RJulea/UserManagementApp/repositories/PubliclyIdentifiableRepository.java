package com.RJulea.UserManagementApp.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.RJulea.UserManagementApp.exceptions.EntityNotFoundException;

@NoRepositoryBean
public interface PubliclyIdentifiableRepository<T> extends JpaRepository<T, Integer> {
    Optional<T> findByPublicIdentifier(UUID publicIdentifier);

    default T findByPublicIdentifierMandatory(UUID publicIdentifier) {
        return findByPublicIdentifier(publicIdentifier)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Could not found entity with public identifier: " + publicIdentifier));
    }
}
