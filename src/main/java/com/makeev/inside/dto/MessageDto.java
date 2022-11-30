package com.makeev.inside.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MessageDto implements Serializable {

    private  String name;
    private  String message;
}