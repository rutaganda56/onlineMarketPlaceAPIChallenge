package org.example.onlinemarketplaceapichallenge.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.example.onlinemarketplaceapichallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String login(Users user) {
      return   userService.login(user);
    }
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }
}
