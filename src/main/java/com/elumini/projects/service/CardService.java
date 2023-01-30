package com.elumini.projects.service;

import com.elumini.projects.domain.Card;
import com.elumini.projects.repository.CardJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            card.setBalance(500L);

            cardRepository.save(card);
            return card;
        }
    }
}
