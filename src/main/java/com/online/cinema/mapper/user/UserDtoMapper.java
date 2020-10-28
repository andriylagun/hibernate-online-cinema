package com.online.cinema.mapper.user;

import com.online.cinema.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserResponseDto toResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
