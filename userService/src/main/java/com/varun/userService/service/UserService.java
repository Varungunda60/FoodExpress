package com.varun.userService.service;

import com.varun.userService.dto.UserDto;
import com.varun.userService.entity.User;
import com.varun.userService.mapper.UserMapper;
import com.varun.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper.INSTANCE::mapUserToUserDto).toList();

    }

    public ResponseEntity<UserDto> getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(userOptional.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
