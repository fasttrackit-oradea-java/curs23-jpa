package ro.fasttrackit.curs23jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs23jpa.domain.Person;
import ro.fasttrackit.curs23jpa.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    private final PersonService service;

    public PersonController(final PersonService service) {
        this.service = service;
    }

    @GetMapping
    List<Person> getAll(@RequestParam(required = false) String name) {
        return service.getAll(name);
    }
}

