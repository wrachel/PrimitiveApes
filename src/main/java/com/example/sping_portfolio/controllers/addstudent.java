package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.seater;
import com.example.sping_portfolio.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

@Controller
public class addstudent {
    @GetMapping("/createstudent")
    public String create(@RequestParam(name="student", required=false, defaultValue="john") String student,
                         @RequestParam(name="period", required=false, defaultValue="1") String period, Model model)
    {

        return "createstudent";
    }

    @GetMapping("/test")
    public String test(@RequestParam(name="allnames", required=true, defaultValue="Harry, Rachel, Calvin, Yajat, Devam")String allnames,
                       @RequestParam(name="numStudents", required=false, defaultValue="0")int numStudents,
                       @RequestParam(name="numTables", required=true, defaultValue="0")int numTables,
                       @RequestParam(name="studentsPerTable", required=true, defaultValue="3")int studentsPerTable, Model model){

        seater randomSeat = new seater(numTables, numStudents, studentsPerTable, allnames);
        ArrayList<Student> newGroups = randomSeat.randomize();
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

    @GetMapping("/seatassign")
    public String seat(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        return "seatassign";
    }
}
