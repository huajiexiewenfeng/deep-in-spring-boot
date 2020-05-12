package com.huajie.deepinspringboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index( Model model) {
        return "index";
    }

    @RequestMapping("/exception")
    public String exception(@RequestParam("value") int value, Model model) {
        return "index";
    }

}
