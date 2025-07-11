package com.demo.spring_boot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Welcome {
    @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome to Dev spring";
    }
}
