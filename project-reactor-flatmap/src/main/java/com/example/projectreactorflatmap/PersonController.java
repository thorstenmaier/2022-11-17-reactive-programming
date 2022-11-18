package com.example.projectreactorflatmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class PersonController {

    @GetMapping(value = "/person", produces = "application/stream+json")
    public Flux<Person> personWebservice(@RequestParam String lastname) {
        return Flux.just(new Person(lastname), new Person(lastname), new Person(lastname))
                .delayElements(Duration.ofSeconds(1));
    }
}
