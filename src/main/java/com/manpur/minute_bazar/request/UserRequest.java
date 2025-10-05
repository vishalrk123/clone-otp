package com.manpur.minute_bazar.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String phoneNumber;
    private String password; // Added password field for login

}
