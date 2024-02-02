package com.varun.userService.mapper;

import com.varun.userService.dto.UserDto;
import com.varun.userService.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapUserDtoToUser(UserDto userDto);
    UserDto mapUserToUserDto(User user);
}
