package com.manpur.minute_bazar.controller;

import com.manpur.minute_bazar.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/")
    public String testMethod() {
        testService.saveTestData("Minute Bazar");
        return "Minute Bazar";
    }
}
