package com.example.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class ConstErrorInfo {

    private int statusCode;
    private String code;
    @ToString.Include private String message;
}
