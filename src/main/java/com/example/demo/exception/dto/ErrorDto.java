package com.example.demo.exception.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.demo.constants.ConstError;
import com.example.demo.constants.ConstErrorInfo;
import com.example.demo.utility.HttpRequestUtility;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ErrorDto {
    @JsonIgnore private ConstErrorInfo error = ConstError.Ok;
    private String request;
    private String code;
    private String message;

    public ErrorDto(final ConstErrorInfo ConstErrorInfo) {
        String uri =
                HttpRequestUtility.getRequestURI()
                        .substring(HttpRequestUtility.getContextPath().length());
        String query = HttpRequestUtility.getHttpServletRequest().getQueryString();
        this.request = uri + (query == null ? "" : "?" + query);

        if (ConstErrorInfo != null) {
            this.error = ConstErrorInfo;
            this.code = ConstErrorInfo.getCode();
            this.message = ConstErrorInfo.getMessage();
        }
    }
}
