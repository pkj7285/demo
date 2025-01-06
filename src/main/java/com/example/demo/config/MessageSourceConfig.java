package com.example.demo.config;

import com.example.demo.util.HeaderUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class MessageSourceConfig {
    @Value("${spring.messages.basename}")
    private String[] basename;

    @Bean
    public MessageSource messageSource() {
        YamlMessageSource source = new YamlMessageSource();
        source.addBasenames(basename);
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                return HeaderUtil.getLocale();
            }

            @Override
            public void setLocale(
                    HttpServletRequest request, HttpServletResponse response, Locale locale) {
                // Do nothing
            }
        };
    }

    private static class YamlMessageSource extends ResourceBundleMessageSource {
        @Override
        protected ResourceBundle doGetBundle(String basename, Locale locale) {
            return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
        }
    }
}
