package com.example.rest.webservices.a5Internationalization;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@RestController
public class HelloWorldInternationalized {
    private MessageSource messageSource;

    public HelloWorldInternationalized(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @GetMapping(path = "/hello-world-internationalized")
    public String helloworldInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
        //return "Hello World";
    }
}
