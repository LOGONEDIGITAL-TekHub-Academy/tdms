package com.logonedigital.tdms.infrastructure.user.http.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotEmpty(message = "Firstname is mandatory")
        @NotBlank(message = "Firstname is mandatory")
        String firstName,
        String lastName,
        @NotEmpty(message = "Email is mandatory")
        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email not well formatted")
        String email,
        @NotEmpty(message = "Password is mandatory")
        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password should be 8 characters minimum")
        String password
) {
}
