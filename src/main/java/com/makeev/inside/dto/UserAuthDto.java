package com.makeev.inside.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserAuthDto implements Serializable {

    private String name;
    private String password;
}