package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.Dto.UserDto;
import org.example.onlinemarketplaceapichallenge.Dto.UserResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Users;

public class UserMapper {
    public Users toUserDto(UserDto userDto) {
       Users users = new Users();
       users.setUsername(userDto.username());
       users.setPassword(userDto.password());
       users.setEmail(userDto.email());
       users.setPhone(userDto.phone());
       return users;
    }
    public UserResponseDto toUserResponseDto(Users users) {
        return new UserResponseDto(users.getFullName());
    }

}
