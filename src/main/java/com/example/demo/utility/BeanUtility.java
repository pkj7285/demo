package com.example.demo.utility;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Objects;

@UtilityClass
public class BeanUtility {

    public static <T> T getBean(Class<T> type) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(
                        request.getSession().getServletContext());
        return (T) Objects.requireNonNull(context).getBean(type);
    }
}
