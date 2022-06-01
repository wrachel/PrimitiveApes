package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.database.ModelRepository;
import com.example.sping_portfolio.database.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

import java.util.ArrayList;

import static com.example.sping_portfolio.seater.sort;

@Controller
public class addstudent implements WebMvcConfigurer{

    @Autowired
    private ModelRepository repository;

    @GetMapping(value= "/createstudent")
    public String create( Student  student )
    {
        return "createstudent";
    }
    @PostMapping(value = "/createstudent")
    public String save(@ModelAttribute Student student, Model model,  BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        String name = "John";
        if (bindingResult.hasErrors()) {
            return "createstudent";
        }
        repository.save(student);
        model.addAttribute("name", name);

        return "redirect:/seatassign";
    }

    @GetMapping(value= "/seatassign")
    public String seat( Model model){
        List<Student> list = repository.listAll();
        model.addAttribute("list", list);
        return "seatassign";
    }
/*
    @GetMapping("/test")
    public String test(@RequestParam(name="allnames", required=true, defaultValue="Harry, Rachel, Calvin, Yajat, Devam")String allnames,
                       @RequestParam(name="numTables", required=true, defaultValue="1")int numTables, Model model){

        seater randomSeat = new seater(numTables, allnames);
        ArrayList<Student> newGroups = randomSeat.randomize();
        sort(newGroups);
        ArrayList<String> tables = new ArrayList<>();
        String table = "Table 1: ";
        int counter = 0;
        int tableNumb = 1;
        for(Student a : newGroups){
            if (counter < 3){
                table = table + a.getStudentName() + " ";
                counter ++;
                System.out.println(counter);
            }
            else{
                tableNumb ++;
                tables.add(table);
                table = "Table " + tableNumb + ": ";
                table = table + a.getStudentName() + " ";
                counter = 1;
            }
        }
        tables.add(table);
        for(String a : tables){
           System.out.println(a);
        }
        model.addAttribute("tables", tables);

        return "randomizeForm";
    }
*/

}

