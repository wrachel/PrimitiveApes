package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addstudent {
    @GetMapping("/createstudent")
    public String create(@RequestParam(name="start", required=false, defaultValue="true") String start, Model model){
        return "createstudent";
    }
}
