package com.manpur.minute_bazar.service;

import com.manpur.minute_bazar.request.UserRequest;
import com.manpur.minute_bazar.utils.ApiResponse;
import com.manpur.minute_bazar.response.UserResponse;

import java.util.List;

public interface UserService {
    ApiResponse<UserResponse> createUser(UserRequest request);
    ApiResponse<List<UserResponse>> getAllUsers();
    ApiResponse<UserResponse> getUserById(Long id);
    ApiResponse<UserResponse> updateUser(Long id, UserRequest request);
    ApiResponse<Object> deleteUser(Long id);
    ApiResponse<UserResponse> loginUser(UserRequest request);
}
