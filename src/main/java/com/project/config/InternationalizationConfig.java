package com.project.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig {

    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        //source.setBasename("i18n/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    public LocaleChangeInterceptor localeChangeInterceptor() {
        //lci.setParamName("lang");
        return new LocaleChangeInterceptor();
    }
}
