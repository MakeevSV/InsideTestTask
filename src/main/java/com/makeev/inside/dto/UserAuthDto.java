package com.makeev.inside.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserAuthDto implements Serializable {

    private final String name;
    private final String password;
}