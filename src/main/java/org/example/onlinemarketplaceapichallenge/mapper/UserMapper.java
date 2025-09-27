package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.dto.UserDto;
import org.example.onlinemarketplaceapichallenge.dto.UserResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public Users toUserDto(UserDto userDto) {
       Users users = new Users();
       users.setUsername(userDto.username());
       users.setPassword(userDto.password());
       users.setEmail(userDto.email());
       users.setPhone(userDto.phone());
       users.setFullName(userDto.fullName());
       users.setRole(userDto.role());
       return users;
    }
    public UserResponseDto toUserResponseDto(Users users) {
        return new UserResponseDto(users.getFullName());
    }

}
