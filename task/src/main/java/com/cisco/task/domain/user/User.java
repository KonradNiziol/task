package com.cisco.task.domain.user;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cisco.task.domain.generic.BaseEntity;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;

    protected User() {
    }

    public User(Integer userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
