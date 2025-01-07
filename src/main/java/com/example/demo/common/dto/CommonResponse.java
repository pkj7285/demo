package com.example.demo.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> {

    private String successOrNot;
    private String statusCode;
    private String errorMessage;

    private T data;
}
