package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.convertor.UserConvertor;
import com.manpur.minute_bazar.model.Cart;
import com.manpur.minute_bazar.model.User;
import com.manpur.minute_bazar.repository.CartRepository;
import com.manpur.minute_bazar.repository.UserRepository;
import com.manpur.minute_bazar.request.UserRequest;
import com.manpur.minute_bazar.response.UserResponse;
import com.manpur.minute_bazar.service.UserService;
import com.manpur.minute_bazar.model.User;   // or whatever package your entity is in

import com.manpur.minute_bazar.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertor userConvertor;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public ApiResponse<UserResponse> createUser(UserRequest request) {
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            return ApiResponse.error("User already exists with this phone number.");
        }

        User user = User.builder()
                .phoneNumber(request.getPhoneNumber())
                .name(request.getName())
                .password(request.getPassword())
                .build();

        User saved = userRepository.save(user);
        cartRepository.save(Cart.builder().userId(saved.getId()).build());

        UserResponse response = userConvertor.convertFrom(saved);
        return ApiResponse.success(response, "User created successfully.");
    }

    @Override
    public ApiResponse<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userRepository.findAll()
                .stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getPhoneNumber()))
                .collect(Collectors.toList());

        return ApiResponse.success(users, "Fetched all users successfully.");
    }

    @Override
    public ApiResponse<UserResponse> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> ApiResponse.success(
                        new UserResponse(user.getId(), user.getName(), user.getPhoneNumber()),
                        "User fetched successfully."))
                .orElseGet(() -> ApiResponse.error("User not found."));
    }

    @Override
    public ApiResponse<UserResponse> updateUser(Long id, UserRequest request) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(request.getName());
                    user.setPhoneNumber(request.getPhoneNumber());
                    User updated = userRepository.save(user);
                    UserResponse response = new UserResponse(updated.getId(), updated.getName(), updated.getPhoneNumber());
                    return ApiResponse.success(response, "User updated successfully.");
                })
                .orElseGet(() -> ApiResponse.error("User not found."));
    }

    @Override
    public ApiResponse<Object> deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return ApiResponse.error("User not found.");
        }
        userRepository.deleteById(id);
        return ApiResponse.builder()
                .success(true)
                .message("User deleted successfully.")
                .data(null)
                .build();
    }

    @Override
    public ApiResponse<UserResponse> loginUser(UserRequest request) {
        User user = userRepository
                .findByPhoneNumberAndPassword(request.getPhoneNumber(), request.getPassword())
                .orElse(null);

        if (user == null) {
            return ApiResponse.error("Invalid phone number or password.");
        }

        UserResponse response = new UserResponse(user.getId(), user.getName(), user.getPhoneNumber());
        return ApiResponse.success(response, "Login successful.");
    }
}
