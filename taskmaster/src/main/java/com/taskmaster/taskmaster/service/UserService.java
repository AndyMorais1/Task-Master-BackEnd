package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.User;
import com.taskmaster.taskmaster.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);

    }

    @Transactional()
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User Update(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
        }
        return userRepository.save(user);
    }

}
