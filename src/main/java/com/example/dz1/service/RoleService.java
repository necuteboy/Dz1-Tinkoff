package com.example.dz1.service;

import com.example.dz1.entity.Role;
import com.example.dz1.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }

    public Role getModerRole() {
        return roleRepository.findByName("ROLE_MODER").get();
    }
}
