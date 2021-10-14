package com.tzivadinovic.komma.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegisterDTO {
    @NotEmpty(message = "First name must not be empty")
    private String firstName;
    @NotEmpty(message = "Last name must not be empty")
    private String lastName;
    @NotEmpty(message = "Username must not be empty")
    private String username;
    @NotEmpty(message = "Email must not be empty")
    private String email;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String repeatedPassword;
}
