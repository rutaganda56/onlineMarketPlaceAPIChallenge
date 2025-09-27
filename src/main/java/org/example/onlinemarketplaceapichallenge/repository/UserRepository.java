package org.example.onlinemarketplaceapichallenge.repository;

import org.example.onlinemarketplaceapichallenge.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    Users findById(Long id);
}
