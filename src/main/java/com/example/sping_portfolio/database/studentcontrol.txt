package com.example.sping_portfolio.database;
import com.example.sping_portfolio.database.Student;
import com.example.sping_portfolio.database.StudentSQL;
import org.json.simple.JSONObject;
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
public class studentcontrol {
    // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
    @Autowired
    private StudentSQL repository;

    @GetMapping("/database/person")
    public String person(Model model) {
        List<Student> list = repository.listAll();
        model.addAttribute("list", list);
        return "database/person";
    }

    /*  The HTML template Forms and PersonForm attributes are bound
        @return - template for person form
        @param - Person Class
    */
    @GetMapping("/database/personcreate")
    public String personAdd(Student person) {
        return "database/personcreate";
    }

    /* Gathers the attributes filled out in the form, tests for and retrieves validation error
    @param - Person object with @Valid
    @param - BindingResult object
     */
    @PostMapping("/database/personcreate")
    public String personSave(@Valid Student person, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "database/personcreate";
        }
        repository.save(person);
        // Redirect to next step
        return "redirect:/database/person";
    }

    @GetMapping("/database/personupdate/{id}")
    public String personUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", repository.get(id));
        return "database/personupdate";
    }

    @PostMapping("/database/personupdate")
    public String personUpdateSave(@Valid Student person, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "database/personupdate";
        }
        repository.save(person);
        // Redirect to next step
        return "redirect:/database/person";
    }

    @GetMapping("/database/persondelete/{id}")
    public String personDelete(@PathVariable("id") long id) {
        repository.delete(id);
        return "redirect:/database/person";
    }

    /*
    #### RESTful API section ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

    /*
    GET List of People
     */
    @RequestMapping(value = "/api/people/get")
    public ResponseEntity<List<Student>> getPeople() {
        return new ResponseEntity<>( repository.listAll(), HttpStatus.OK);
    }

    /*
    GET individual Person using ID
     */
    @RequestMapping(value = "/api/person/get/{id}")
    public ResponseEntity<Student> getPerson(@PathVariable long id) {
        return new ResponseEntity<>( repository.get(id), HttpStatus.OK);
    }

    /*
    DELETE individual Person using ID
     */
    @RequestMapping(value = "/api/person/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePerson(@PathVariable long id) {
        repository.delete(id);
        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
    }


    /*
    POST Aa record by Requesting Parameters from URI
     */
    @RequestMapping(value = "/api/person/post", method = RequestMethod.POST)
    public ResponseEntity<Object> postPerson(@RequestParam("email") String email,
                                             @RequestParam("name") String name,
                                             @RequestParam("dob") String dobString) {
        Date dob;
        try {
            dob = new SimpleDateFormat("MM-dd-yyyy").parse(dobString);
        } catch (Exception e) {
            return new ResponseEntity<>(dobString +" error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
        }
        // A person object WITHOUT ID will create a new record
        Student person = new Student(email, name, dob);
        repository.save(person);
        return new ResponseEntity<>(email +" is created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/database/person_search")
    public String person() {
        return "database/person_search";
    }

    /*
    The personSearch API looks across database for partial match to term (k,v) passed by RequestEntity body
     */
    @RequestMapping(value = "/api/person_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> personSearch(RequestEntity<Object> request) {

        // extract term from RequestEntity
        JSONObject json = new JSONObject((Map) Objects.requireNonNull(request.getBody()));
        String term = (String) json.get("term");

        // custom JPA query to filter on term
        List<Student> list = repository.listLikeNative(term);

        // return resulting list and status, error checking should be added
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
