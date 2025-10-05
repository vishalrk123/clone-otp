package com.manpur.minute_bazar.controller;

import com.manpur.minute_bazar.request.UserRequest;
import com.manpur.minute_bazar.utils.ApiResponse;
import com.manpur.minute_bazar.response.UserResponse;
import com.manpur.minute_bazar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/getAll")
    public ApiResponse<List<UserResponse>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ApiResponse<UserResponse> loginUser(@RequestBody UserRequest request) {
        return userService.loginUser(request);
    }

}
