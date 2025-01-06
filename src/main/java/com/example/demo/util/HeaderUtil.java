package com.example.demo.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;

@UtilityClass
public class HeaderUtil {

    public static Locale getLocale() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        String languageCode =
                request.getHeader("X-Language-Code"); // ToDo : 추후에 공통에서 제공하는 코드로 Locale 설정을 변경할 것임
        return "en".equalsIgnoreCase(languageCode) ? Locale.ENGLISH : Locale.KOREAN;
    }
}
