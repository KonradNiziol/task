package com.cisco.task.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;


}
