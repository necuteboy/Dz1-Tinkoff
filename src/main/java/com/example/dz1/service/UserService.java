package com.example.dz1.service;

import com.example.dz1.config.PasswordEncoderConfiguration;
import com.example.dz1.dto.request.RegistrationUserDto;
import com.example.dz1.entity.User;
import com.example.dz1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoderConfiguration passwordEncoder;
    private final RoleService roleService;

    public Optional<User> findByUserName(String name) {
        return userRepository.findByName(name);
    }

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

    public User createUser(RegistrationUserDto registrationUserDto) {
        User user = new User();
        user.setName(registrationUserDto.getUsername());
        user.setPassword(passwordEncoder.passwordEncoder().encode(registrationUserDto.getPassword()));
        user.setRoles(List.of(roleService.getUserRole()));
        user.setRole("USER");
        return userRepository.save(user);

    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username).orElseThrow(
                () -> new UsernameNotFoundException("Пользователь не найден"));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList()));
    }
}
