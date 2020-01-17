package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getInto(){
        return "redirect:index";
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }
}
