package com.elumini.projects.config;

import com.elumini.projects.domain.Card;
import com.elumini.projects.repository.CardJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Configuration
public class LocalConfig {

    @Autowired
    private CardJPA cardRepository;

    @Bean
    public void startDB(){
        Random rn = new Random();
        Card c1 = new Card(rn.nextInt(), "01234567890123", "1234", BigDecimal.valueOf(500.0));
        Card c2 = new Card(rn.nextInt(), "5248898969353237", "1234", BigDecimal.valueOf(500.0));

        cardRepository.saveAll(List.of(c1, c2));
    }
}
