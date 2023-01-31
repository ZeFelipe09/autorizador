package com.elumini.projects.service;

import com.elumini.projects.domain.Card;
import com.elumini.projects.repository.CardJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

@Service
public class CardService {
    @Autowired
    private CardJPA cardRepository;

    public Card createCard(Card card) {
        if (cardRepository.findCardByCardNumber(card.getCardNumber()) != null) {
            return null;
        } else {
            card.setId(UUID.randomUUID());
            card.setBalance(BigDecimal.valueOf(500.00));

            cardRepository.save(card);
            return card;
        }
    }

    public Double getBalance(String cardNumber){
        Card card = cardRepository.findCardByCardNumber(cardNumber);
        if (card != null){
            return card.getBalance().doubleValue();
        }else{
            return null;
        }
    }
}
