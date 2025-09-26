package org.example.onlinemarketplaceapichallenge.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.onlinemarketplaceapichallenge.Dto.UserDto;
import org.example.onlinemarketplaceapichallenge.Dto.UserResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.example.onlinemarketplaceapichallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(Users user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserDto dto) {
        return userService.register(dto);
    }
    @GetMapping("/fetchAllUsers")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMsg = error.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}