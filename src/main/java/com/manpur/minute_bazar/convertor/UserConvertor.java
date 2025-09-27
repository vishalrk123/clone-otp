package com.manpur.minute_bazar.convertor;

import com.manpur.minute_bazar.model.User;
import com.manpur.minute_bazar.request.UserRequest;
import com.manpur.minute_bazar.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public User convertTo(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .build();
    }

    public UserResponse convertFrom(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
