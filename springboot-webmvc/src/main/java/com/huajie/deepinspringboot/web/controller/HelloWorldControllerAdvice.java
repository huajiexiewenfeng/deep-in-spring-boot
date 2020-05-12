package com.huajie.deepinspringboot.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 可以将一些公共的代码抽取到其中，方便代码的重构
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    @ModelAttribute("jsessionid")
    public String jsessionid(@CookieValue("JSESSIONID") String jsessionid) {
        return jsessionid;
    }

    @ModelAttribute("message")
    public String message() {
        return "hello,world";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}
