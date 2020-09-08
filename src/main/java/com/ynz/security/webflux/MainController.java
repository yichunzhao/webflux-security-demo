package com.ynz.security.webflux;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final DicePairRoll dicePairRoll;

    @GetMapping("hello")
    public Mono<String> getGreeting() {
        return Mono.just("this is greeting from web flux test controller");
    }

    @GetMapping("roll")
    public Mono<PairDiceDto> getDiceRoll() {
        dicePairRoll.rollDice();
        return Mono.just(PairDiceDto.builder().die1(dicePairRoll.getDie1()).die2(dicePairRoll.getDie2())
                .total(dicePairRoll.getTotal()).build());
    }

}
