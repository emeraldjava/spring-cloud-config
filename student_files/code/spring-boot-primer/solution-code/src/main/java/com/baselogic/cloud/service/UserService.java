package com.baselogic.cloud.service;

import com.baselogic.cloud.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @RequestMapping("/")
    public String home() {
        return "Spring Boot Primer";
    }

    @RequestMapping("/{firstName}/{lastName}")
    public User newUser(@PathVariable("firstName") String firstName,
    		            @PathVariable("lastName") String lastName) {
        return new User(firstName, lastName);
    }
}
