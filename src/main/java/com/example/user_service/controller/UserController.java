package com.example.user_service.controller;

import com.example.user_service.data.User;
import com.example.user_service.data.userDTO.*;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/")
    public UserResponseDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

    @PutMapping(path = "/")
    public UserResponseDTO updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        return userService.updateUser(userUpdateDTO);
    }

    @GetMapping(path = "/")
    public UserPaginatedDTO<UserResponseDTO> getUsers(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getUsers(page, size);
    }

    @GetMapping(path = "/all")
    public  UserPaginatedDTO<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping(path = "/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO userLoginDTO){
        return userService.login(userLoginDTO.getEmail(), userLoginDTO.getPassword());
    }
}
