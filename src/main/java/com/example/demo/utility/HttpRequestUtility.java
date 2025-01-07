package com.example.demo.utility;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@UtilityClass
public class HttpRequestUtility {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
    }

    public static String getRequestURI() {
        return getHttpServletRequest().getRequestURI();
    }

    public static String getContextPath() {
        return getHttpServletRequest().getContextPath();
    }
}
