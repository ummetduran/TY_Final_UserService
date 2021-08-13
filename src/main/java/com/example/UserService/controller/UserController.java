package com.example.UserService.controller;

import com.example.UserService.models.dto.UserIdListDTO;
import com.example.UserService.models.entities.User;
import com.example.UserService.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<User>  addUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }

}
