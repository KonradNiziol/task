package com.cisco.task.service.mapper;

import org.springframework.stereotype.Component;

import com.cisco.task.domain.user.User;
import com.cisco.task.service.dto.UserDto;

@Component
public class UserConverter {

    public UserDto convertFrom(final User user) {
        return UserDto
                .builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
