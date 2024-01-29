package com.booleanuk.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private String name;
    private String email;
}
