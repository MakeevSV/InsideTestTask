package com.makeev.inside.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserAuthDto implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
}