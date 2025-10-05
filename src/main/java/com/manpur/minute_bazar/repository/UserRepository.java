package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByPhoneNumberAndPassword(String phoneNumber, String password);
}
