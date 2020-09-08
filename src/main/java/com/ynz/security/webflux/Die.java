package com.ynz.security.webflux;

import java.util.Random;


public class Die {
    private int nextNumber;

    public void roll() {
        Random r = new Random();
        nextNumber = r.nextInt(6) + 1;
    }

    public int getValue() {
        return this.nextNumber;
    }

}
