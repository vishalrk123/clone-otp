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
                .phoneNumber(userRequest.getPhoneNumber())
                .build();
    }

    public UserResponse convertFrom(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
