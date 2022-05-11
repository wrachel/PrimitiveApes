package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class index {
    @GetMapping("/index")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        return "index";
    }
}
