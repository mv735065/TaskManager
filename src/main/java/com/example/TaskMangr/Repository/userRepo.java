package com.example.TaskMangr.Repository;

import com.example.TaskMangr.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<User,Integer> {


    Optional<User> findByName(String username);
}
