package com.example.ReactiveProgrammingProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/greeting")
    public Mono<String> greetingMessage(){
        return computeMessage()
                .zipWith(getNameFromDB())
                .map(value->{
                    return value.getT1()+value.getT2();
                });
    }

    private Mono<String> computeMessage(){
        return Mono.just("Hello").delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> getNameFromDB(){
        return Mono.just("Tyler").delayElement(Duration.of(5));
    }
}
