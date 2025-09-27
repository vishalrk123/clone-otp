package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
