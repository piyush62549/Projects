package com.example.ProjectMS2.controllers;

import com.example.ProjectMS2.Dto.Person;
import com.example.ProjectMS2.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @GetMapping("/person/data")
    public ResponseEntity<Person> personRecord(@RequestParam int personId){
            Person personData = personService.PersonData(personId);
            return new ResponseEntity<>(personData,HttpStatus.OK);
        }

    }

