package com.example.dz1.mapper;

import com.example.dz1.dto.UserDto;
import com.example.dz1.dto.UserDtoRequest;
import com.example.dz1.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User getUserFromDto(UserDtoRequest userDto);

    UserDto getDtoFromUser(User user);
}
