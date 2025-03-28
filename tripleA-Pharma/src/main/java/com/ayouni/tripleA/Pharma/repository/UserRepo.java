package com.ayouni.tripleA.Pharma.repository;

import com.ayouni.tripleA.Pharma.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
