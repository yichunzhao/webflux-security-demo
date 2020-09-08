package com.ynz.security.webflux;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class DicePairRoll {
    private final Die die1;
    private final Die die2;

    private int total;

    public void rollDice() {

        die1.roll();
        die2.roll();

        total = die1.getValue() + die2.getValue();
    }

}
