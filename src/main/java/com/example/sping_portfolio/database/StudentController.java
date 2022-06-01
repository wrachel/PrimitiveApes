package com.example.sping_portfolio.database;
//import com.example.sping_portfolio.database.StudentSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@Controller
public class StudentController implements WebMvcConfigurer {

    // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
    @Autowired
    private ModelRepository repository;


    @GetMapping(value = "/database/student_list")
    public String student(Model model) {
        List<Student> list = repository.listAll();
        model.addAttribute("list", list);
        return "database/student_list";
    }


    @GetMapping(value = "/database/student_add")
    public String studentadd(Student student) {

        return "database/student_add";
    }


    @PostMapping(value = "/database/student_add")
    public String studentsave(@ModelAttribute Student student, Model model,  BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        String name = "hi";
        if (bindingResult.hasErrors()) {
            return "student_update";
        }
        repository.save(student);
        model.addAttribute("name", name);

        return "redirect:/database/student_list";
    }

    @GetMapping(value = "/database/student_update/{id}")
    public String studentupdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", repository.get(id));
        return "database/student_update";
    }

    @PostMapping(value = "/database/student_update")
    public String studentsaveupdate(@ModelAttribute Student student, Model model, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "/database/student_update";
        }
        String name = "hi";
        model.addAttribute("name", name);
        repository.save(student);

        return "redirect:/seatassign";
    }

    @GetMapping("/database/student_delete/{id}")
    public String studentdelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", repository.get(id));
        return "database/student_delete";
    }

    @PostMapping(value = "/database/student_delete")
    public String student_delete(@ModelAttribute Student student, Model model, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "/database/student_update";
        }
        String name = "hi";


        model.addAttribute("name", name);
        repository.delete(student.getId());

        return "redirect:/seatassign";
    }

    /*
    #### RESTful API section ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

        /*
        GET List of People
         */
//        @RequestMapping(value = "/api/colleges/get")
//        public ResponseEntity<List<College>> getcolleges() {
//            return new ResponseEntity<>( repository.listAll(), HttpStatus.OK);
//        }
//
//        /*
//        GET individual Person using ID
//         */
//        @RequestMapping(value = "/api/college/get/{id}")
//        public ResponseEntity<College> getcollege(@PathVariable long id) {
//            return new ResponseEntity<>( repository.get(id), HttpStatus.OK);
//        }

        /*
        DELETE individual Person using ID
         */
//        @RequestMapping(value = "/api/person/delete/{id}", method = RequestMethod.DELETE)
//        public ResponseEntity<Object> deletecollege(@PathVariable long id) {
//            repository.delete(id);
//            return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
//        }


        /*
        POST Aa record by Requesting Parameters from URI
         */
//        @RequestMapping(value = "/api/college/post", method = RequestMethod.POST)
//        public ResponseEntity<Object> postcollege(@RequestParam("name") String name,
//                                                 @RequestParam("deadline") String deadline) {
//            Date date;
//            try {
//                date = new SimpleDateFormat("MM-dd-yyyy").parse(deadline);
//            } catch (Exception e) {
//                return new ResponseEntity<>(deadline +" error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
//            }
//            // A college object WITHOUT ID will create a new record
//            College college = new College(name, date);
//            repository.save(college);
//            return new ResponseEntity<>(name +" was added successfully", HttpStatus.CREATED);
//        }

//        @GetMapping("college_search")
//        public String college() {
//            return "college_search";
//        }

        /*
        The personSearch API looks across database for partial match to term (k,v) passed by RequestEntity body
         */
//        @RequestMapping(value = "/api/person_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//        public ResponseEntity<Object> collegesearch(RequestEntity<Object> request) {
//
//            // extract term from RequestEntity
//            JSONObject json = new JSONObject((Map) Objects.requireNonNull(request.getBody()));
//            String term = (String) json.get("term");
//
//            // custom JPA query to filter on term
//            List<College> list = repository.listLikeNative(term);
//
//            // return resulting list and status, error checking should be added
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }

}

