package com.example.dz1.controller;

import com.example.dz1.dto.UserDto;
import com.example.dz1.mapper.UserMapper;
import com.example.dz1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @QueryMapping
    public UserDto getUser(@Argument Long id){
        return userMapper.getDtoFromUser(userService.getUserById(id));
    }

    @MutationMapping
    public UserDto saveUser(@Argument String name, @Argument int age){
        return userMapper.getDtoFromUser(userService.saveUser(name,age));
    }
}
