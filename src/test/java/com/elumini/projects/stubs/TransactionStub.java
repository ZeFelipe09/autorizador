package com.elumini.projects.stubs;

import com.elumini.projects.domain.Transaction;

public class TransactionStub {

    public static Transaction transactionTest(String cardNumber, String password, Double value){
        return new Transaction(cardNumber, password, value);
    }
}
