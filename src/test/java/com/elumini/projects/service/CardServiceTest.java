package com.elumini.projects.service;

import com.elumini.projects.domain.Card;
import com.elumini.projects.repository.CardJPA;
import com.elumini.projects.stubs.CardStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.elumini.projects.stubs.CardStub.cardTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    @Mock
    private CardJPA cardRepoditory;

    private Card card;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCard() {
        card = cardTest("3214987765445256", "1234");

        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(null);

        Card response = cardService.createCard(card);

        assertEquals(card.getCardNumber(), response.getCardNumber());
        assertEquals(card.getPassword(), response.getPassword());
        assertEquals(card.getBalance(), response.getBalance());
    }

    @Test
    void cardAlreadyCreated() {
        card = cardTest("3214987765445256", "1234");

        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(card);

        Card response = cardService.createCard(card);

        assertNull(response);
    }

    @Test
    void getBalance() {
        card = cardTest("3214987765445256", "1234");

        when(cardRepoditory.findCardByCardNumber(any())).thenReturn(card);

        Double response = cardService.getBalance(card.getCardNumber());

        assertEquals(card.getBalance().doubleValue(), response);
    }
}