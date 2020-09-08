package com.ynz.security.webflux;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PairDiceDto {
    private Die die1;
    private Die die2;
    private int total;
}
