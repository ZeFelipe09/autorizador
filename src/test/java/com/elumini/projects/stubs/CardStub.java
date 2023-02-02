package com.elumini.projects.stubs;

import com.elumini.projects.domain.Card;

import java.math.BigDecimal;
import java.util.UUID;

public class CardStub {

    public static Card cardTest(String cardNumber, String password){
        return new Card(UUID.randomUUID(), cardNumber, password, BigDecimal.valueOf(500.0));
    }
}
