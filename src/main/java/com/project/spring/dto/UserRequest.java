package com.project.spring.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class UserRequest {
    @NotBlank(message="Name cannot be empty")
    private String name;

    @Email(message="Email should be valid")
    private String email;
    private String password;
    private Long roleId;
}

