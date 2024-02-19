package com.example.dz1.controller;

import com.example.dz1.dto.UserDto;
import com.example.dz1.dto.UserDtoRequest;
import com.example.dz1.mapper.UserMapper;
import com.example.dz1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @GetMapping("/get")
    public UserDto getUser(@RequestParam  Long id){
        return userMapper.getDtoFromUser(userService.getUserById(id));
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDtoRequest userDto){
        var user = userMapper.getUserFromDto(userDto);
        return userMapper.getDtoFromUser(userService.saveUser(user));
    }
}
