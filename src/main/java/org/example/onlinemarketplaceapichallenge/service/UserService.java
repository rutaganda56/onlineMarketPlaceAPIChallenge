package org.example.onlinemarketplaceapichallenge.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.onlinemarketplaceapichallenge.Dto.UserDto;
import org.example.onlinemarketplaceapichallenge.Dto.UserResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.UserMapper;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.example.onlinemarketplaceapichallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);

    public String login(@RequestBody Users user) {
        return jwtService.generateToken(user.getUsername());
    }
    public UserResponseDto register(@RequestBody UserDto dto) {
        var user=userMapper.toUserDto(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser=userRepository.save(user);
        return userMapper.toUserResponseDto(savedUser);
    }
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponseDto).collect(Collectors.toList());
    }
}
