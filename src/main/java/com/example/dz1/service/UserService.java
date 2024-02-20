package com.example.dz1.service;

import com.example.dz1.entity.User;
import com.example.dz1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(String name, int age) {
        var user = User.builder()
                .name(name)
                .age(age)
                .build();
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
