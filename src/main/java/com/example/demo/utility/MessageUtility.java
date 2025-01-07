package com.example.demo.utility;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;

@Slf4j
@UtilityClass
public class MessageUtility {

    public static String getMessage(String code) {
        try {
            MessageSource messageSource = BeanUtility.getBean(MessageSource.class);
            return messageSource.getMessage(code, null, HeaderUtility.getLocale());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return code;
        }
    }

    public static String getMessage(String code, Object[] args) {
        try {
            MessageSource messageSource = BeanUtility.getBean(MessageSource.class);
            return messageSource.getMessage(code, args, HeaderUtility.getLocale());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return code;
        }
    }
}
