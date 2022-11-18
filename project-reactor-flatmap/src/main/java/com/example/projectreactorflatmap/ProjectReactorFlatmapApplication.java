package com.example.projectreactorflatmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProjectReactorFlatmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectReactorFlatmapApplication.class, args);


        Flux.just("Maier", "Müller", "Schmitt")
                .flatMap(lastname -> personWebservice(lastname))
                .subscribe(System.out::println);
    }

    public static Flux<Person> personWebservice(String lastname) {
        return WebClient.create("http://localhost:8080/person")
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("lastname", lastname).build())
                .retrieve()
                .bodyToFlux(Person.class);
    }

}
