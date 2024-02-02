package com.varun.userService.controller;

import com.varun.userService.dto.UserDto;
import com.varun.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getUserById/{Id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer Id){
        return userService.getUserById(Id);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return  new ResponseEntity<>(userService.create(userDto),HttpStatus.OK);
    }

}
