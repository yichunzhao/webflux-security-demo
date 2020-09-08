package com.ynz.security.webflux;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
