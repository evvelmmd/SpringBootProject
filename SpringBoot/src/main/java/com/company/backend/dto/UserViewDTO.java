package com.company.backend.dto;

import com.company.backend.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {
    public static final long serialVersionID = 1L;

    private final String firstName;

    private  final String lastName;

    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getFirstName(), user.getLastName());
    }
}
