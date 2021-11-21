package com.cisco.task.service.mapper;

import org.junit.jupiter.api.Test;

import com.cisco.task.domain.user.User;
import com.cisco.task.service.dto.UserDto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserConverterTest {

    private final UserConverter userConverter = new UserConverter();

    //NOTE: sample unit test that verifies the correct operation of the mappers
    @Test
    void correctMappingForUser() {
        //GIVEN
        final User user = initUser(1, "Konrad", "Niziol", "kn@gmail.com");
        //WHEN
        final UserDto userDto = userConverter.convertFrom(user);
        //THEN
        assertThat(userDto.getUserId(), is(equalTo(user.getUserId())));
        assertThat(userDto.getFirstName(), is(equalTo(user.getFirstName())));
        assertThat(userDto.getLastName(), is(equalTo(user.getLastName())));

    }

    private User initUser(final int userId, final String firstName, final String  secondName, final String email) {
        return new User(userId, firstName, secondName, email);
    }
}