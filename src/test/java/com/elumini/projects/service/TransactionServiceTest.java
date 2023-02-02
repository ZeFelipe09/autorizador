package com.elumini.projects.service;

import com.elumini.projects.domain.Card;
import com.elumini.projects.domain.Transaction;
import com.elumini.projects.error.TransactionException;
import com.elumini.projects.repository.CardJPA;
import com.elumini.projects.stubs.CardStub;
import com.elumini.projects.stubs.TransactionStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.UUID;

import static com.elumini.projects.stubs.CardStub.cardTest;
import static com.elumini.projects.stubs.TransactionStub.transactionTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private CardJPA cardRepoditory;

    private Card card;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTransaction() {
        card = cardTest("01234567890123", "1234");
        transaction = transactionTest("01234567890123", "1234", 100.0);

        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(card);

        Double response = transactionService.createTransaction(transaction);

        assertNotNull(response);
        assertEquals(400.0, response);
    }

    @Test
    void cardNotExistsTest(){
        transaction = transactionTest("01234567890123", "1233", 100.0);


        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(null);

        try{
            transactionService.createTransaction(transaction);
        }catch (Exception ex){
            assertEquals(TransactionException.class, ex.getClass());
            assertEquals("CARTAO_INEXISTENTE", ex.getMessage());
        }
    }

    @Test
    void invalidPasswordTest(){
        card = cardTest("01234567890123", "1234");
        transaction = transactionTest("01234567890123", "1233", 100.0);

        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(card);

        try{
            transactionService.createTransaction(transaction);
        }catch (Exception ex){
            assertEquals(TransactionException.class, ex.getClass());
            assertEquals("SENHA_INVALIDA", ex.getMessage());
        }
    }

    @Test
    void noBalanceTest(){
        card = cardTest("01234567890123", "1234");
        transaction = transactionTest("01234567890123", "1234", 700.0);

        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(card);

        try{
            transactionService.createTransaction(transaction);
        }catch (Exception ex){
            assertEquals(TransactionException.class, ex.getClass());
            assertEquals("SALDO_INSUFICIENTE", ex.getMessage());
        }
    }


}