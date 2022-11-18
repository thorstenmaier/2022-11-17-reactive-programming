package com.example.projectreactorflatmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/person", produces = "application/stream+json")
    public Flux<Person> personWebservice(@RequestParam String lastname) {
        return personRepository.findAll();
    }
}
