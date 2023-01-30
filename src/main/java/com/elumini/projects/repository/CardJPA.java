package com.elumini.projects.repository;

import com.elumini.projects.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardJPA extends JpaRepository<Card, UUID> {

    Card findCardByCardNumber(String cardNumber);
}
