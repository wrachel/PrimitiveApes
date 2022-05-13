package com.example.sping_portfolio.database;
//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StudentController implements WebMvcConfigurer {
    //
//        // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
    @Autowired
    private StudentSQL repository;

    @GetMapping(value = "/database/student_add")
    public String studentadd(Student student) {

        return "database/student_add";
    }

    @PostMapping(value = "/database/student_add")
    public String studentsave(@ModelAttribute Student student, Model model,  BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        String name = "hi";
//        if (bindingResult.hasErrors()) {
//            return "/database/college_update";
//        }
        repository.save(student);
        model.addAttribute("name", name);

        return "redirect:/database/student_list";
    }


}


//
//        @GetMapping(value = "/database/student_list")
//        public String student(Model model) {
//            List<Student> list = repository.listAll();
//            model.addAttribute("list", list);
//            return "database/student_list";
//        }
//
//
//        @GetMapping(value = "/database/student_add")
//        public String collegeadd(Student student) {
//
//            return "database/student_add";
//        }
//
//
//        @PostMapping(value = "/database/college_add")
//        public String collegesave(@ModelAttribute Student student, Model model, BindingResult bindingResult) {
//            // Validation of Decorated PersonForm attributes
//            String name = "hi";
//
//            repository.save(student);
//            model.addAttribute("name", name);
//
//            return "redirect:/database/college_list";
//        }
//
//        @GetMapping(value = "/database/college_update/{id}")
//        public String collegeupdate(@PathVariable("id") int id, Model model) {
//            model.addAttribute("college", repository.get(id));
//            return "database/college_update";
//        }
//
//        @PostMapping(value = "/database/college_update")
//        public String collegesaveupdate(@ModelAttribute College college, Model model, BindingResult bindingResult) {
//            // Validation of Decorated PersonForm attributes
//            if (bindingResult.hasErrors()) {
//                return "/database/college_update";
//            }
//            String name = "hi";
//            model.addAttribute("name", name);
//            repository.save(college);
//
//            return "redirect:/database/college_list";
//        }
//
//        @GetMapping("/database/college_delete/{id}")
//        public String collegedelete(@PathVariable("id") int id, Model model) {
//            model.addAttribute("college", repository.get(id));
//            return "database/college_delete";
//        }
//
//        @PostMapping(value = "/database/college_delete")
//        public String collegedelete(@ModelAttribute College college, Model model, BindingResult bindingResult) {
//            // Validation of Decorated PersonForm attributes
//            if (bindingResult.hasErrors()) {
//                return "/database/college_update";
//            }
//            String name = "hi";
//
//
//            model.addAttribute("name", name);
//            repository.delete(college.getId());
//
//            return "redirect:/database/college_list";
//        }
