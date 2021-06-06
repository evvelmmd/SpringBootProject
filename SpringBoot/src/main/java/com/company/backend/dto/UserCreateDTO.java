package com.company.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class UserCreateDTO {

    @NotNull(message = "username cant be null")
    private String username;

    private String firstName;

    private String lastName;

}
