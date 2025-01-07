package com.example.demo.exception.dto;

import com.example.demo.exception.dto.ErrorDto;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Error {

    private ErrorDto error;

    public Error(final ErrorDto error) {
        this.error = error;
    }
}
