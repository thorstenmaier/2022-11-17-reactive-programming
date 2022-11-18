package com.example.projectreactorflatmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DatabaseClient databaseClient;

    @PostConstruct
    public void init() {
        Flux.just("CREATE TABLE Person (id int, name varchar(255))")
                .map(sql -> databaseClient.sql(sql).fetch().rowsUpdated())
                .blockLast().subscribe();

        Flux.just("Maier1", "Maier2")
                .map(Person::new)
                .flatMap(personRepository::save)
                .subscribe();

    }
}
