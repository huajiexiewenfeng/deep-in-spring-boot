package com.huajie.deepinspringboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestHeader("Accept-Language") String acceptLanguage, @CookieValue("JSESSIONID") String jsessionid, Model model) {
        model.addAttribute("acceptLanguage", acceptLanguage);
        model.addAttribute("jsessionid", jsessionid);
        return "index";
    }

    @RequestMapping("/exception")
    public String exception(@RequestParam("value") int value, Model model) {
        return "index";
    }

}
