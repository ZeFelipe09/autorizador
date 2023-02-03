package com.elumini.projects.stubs;

import com.elumini.projects.domain.Card;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public class CardStub {

    public static Card cardTest(String cardNumber, String password){
        Random rm = new Random();
        return new Card(rm.nextInt(), cardNumber, password, BigDecimal.valueOf(500.0));
    }
}
