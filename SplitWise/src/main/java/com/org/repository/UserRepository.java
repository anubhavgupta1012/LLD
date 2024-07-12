package com.org.repository;

import com.org.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer userId);
}
