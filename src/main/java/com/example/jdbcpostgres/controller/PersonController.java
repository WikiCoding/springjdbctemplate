package com.example.jdbcpostgres.controller;

import com.example.jdbcpostgres.model.Person;
import com.example.jdbcpostgres.repository.ContentJdbcTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin
public class PersonController {
    private final ContentJdbcTemplateRepository repository;

    @Autowired
    public PersonController(ContentJdbcTemplateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> getEveryone() {
        return repository.getAllPeople();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody Person person) {
        repository.insertPerson(person.name());
    }
}
