package com.ynz.security.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    @GetMapping("hello")
    public Mono<String> getGreeting() {
        return Mono.just("this is greeting from web flux test controller");
    }


}
