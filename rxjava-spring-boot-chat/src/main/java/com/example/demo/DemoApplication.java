package com.example.demo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private PublishSubject<String> messages = PublishSubject.create();

    @Scheduled(fixedRate = 3000)
    public void createMessage() {
        messages.onNext("Scheduled: " + new Date());
    }

    @GetMapping(value = "stream", produces = "text/event-stream")
    public Observable<String> stream() {
        return messages;
    }

    // http://localhost:8080/send?message=Hallo
    @GetMapping("send")
    public void send(@RequestParam String message) {
        messages.onNext(message);
    }

}
