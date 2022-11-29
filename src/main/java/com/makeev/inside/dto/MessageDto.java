package com.makeev.inside.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageDto implements Serializable {

    private final String name;
    private final String message;
}