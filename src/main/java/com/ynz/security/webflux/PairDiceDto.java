package com.ynz.security.webflux;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PairDiceDto {
    private Die die1;
    private Die die2;
    private int total;
}
