package com.example.dz1.service;

import com.example.dz1.entity.User;
import com.example.dz1.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Transactional
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @Transactional
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
