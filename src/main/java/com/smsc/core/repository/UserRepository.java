package com.smsc.core.repository;

import com.smsc.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Page<User> findByRole(User.Role role, Pageable pageable);

    List<User> findByRole(User.Role role);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
