package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.UserDto;
import org.example.onlinemarketplaceapichallenge.dto.UserResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.UserMapper;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.example.onlinemarketplaceapichallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);

    public String login( Users user) {
        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()) {
            System.out.println("success");
            return jwtService.generateToken(user.getUsername());

        }
        return "failed to authenticate";
    }
    public UserResponseDto register( UserDto dto) {
        var user=userMapper.toUserDto(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser=userRepository.save(user);
        return userMapper.toUserResponseDto(savedUser);
    }
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponseDto).collect(Collectors.toList());
    }
    public UserResponseDto updateUser(int id, UserDto userDto) {
        var existingUser=userRepository.findById(id).orElse(new Users());
        existingUser.setUsername(userDto.username());
        existingUser.setPassword(passwordEncoder.encode(userDto.password()));
        existingUser.setRole(userDto.role());
        existingUser.setPhone(userDto.phone());
        existingUser.setFullName(userDto.fullName());
        existingUser.setEmail(userDto.email());
        Users updatedUser=userRepository.save(existingUser);
        return new UserResponseDto(updatedUser.getFullName());
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
