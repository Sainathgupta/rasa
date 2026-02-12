package com.rasa.repositories;

import com.rasa.entity.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserById(Integer id);
    public User findUserByUsername(String username);
    public Optional<User> findByEmail(String email);
}
