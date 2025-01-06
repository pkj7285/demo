package com.example.demo.util;

import com.example.demo.util.BeanUtil;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;

@Slf4j
@UtilityClass
public class MessageUtil {

    public static String getMessage(String code) {
        try {
            MessageSource messageSource = BeanUtil.getBean(MessageSource.class);
            return messageSource.getMessage(code, null, HeaderUtil.getLocale());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return code;
        }
    }

    public static String getMessage(String code, Object[] args) {
        try {
            MessageSource messageSource = BeanUtil.getBean(MessageSource.class);
            return messageSource.getMessage(code, args, HeaderUtil.getLocale());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return code;
        }
    }
}
