package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addstudent {
    @GetMapping("/createstudent")
    public String create(@RequestParam(name="student", required=false, defaultValue="john") String student,
                         @RequestParam(name="period", required=false, defaultValue="1") String period,Model model)
    {
        return "createstudent";
    }
}
