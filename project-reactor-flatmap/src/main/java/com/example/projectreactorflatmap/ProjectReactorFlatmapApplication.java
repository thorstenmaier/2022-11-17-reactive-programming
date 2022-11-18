package com.example.projectreactorflatmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
public class ProjectReactorFlatmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectReactorFlatmapApplication.class, args);


		Flux.just("Maier")
				.flatMap(lastname -> personWebservice(lastname))
				.subscribe(System.out::println);
	}

	public static Flux<Person> personWebservice(String lastname) {
		return Flux.just(new Person(lastname), new Person(lastname), new Person(lastname))
				.delayElements(Duration.ofSeconds(1));
	}

}
