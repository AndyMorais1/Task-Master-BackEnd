package com.taskmaster.taskmaster.repository;

import com.taskmaster.taskmaster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
