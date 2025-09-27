package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.convertor.UserConvertor;
import com.manpur.minute_bazar.model.Cart;
import com.manpur.minute_bazar.repository.CartItemRepository;
import com.manpur.minute_bazar.repository.CartRepository;
import com.manpur.minute_bazar.repository.UserRepository;
import com.manpur.minute_bazar.request.UserRequest;
import com.manpur.minute_bazar.response.UserResponse;
import com.manpur.minute_bazar.service.UserService;
import com.manpur.minute_bazar.model.User;   // or whatever package your entity is in

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
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .build();
        User saved = userRepository.save(user);
        cartRepository.save(Cart.builder().userId(saved.getId()).build());
        return userConvertor.convertFrom(saved);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = (User) userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = (User) userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User updated = userRepository.save(user);
        return new UserResponse(updated.getId(), updated.getName(), updated.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
