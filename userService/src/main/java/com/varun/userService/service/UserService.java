package com.varun.userService.service;

import com.varun.userService.dto.UserDto;
import com.varun.userService.entity.User;
import com.varun.userService.mapper.UserMapper;
import com.varun.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper.INSTANCE::mapUserToUserDto).toList();

    }
}
