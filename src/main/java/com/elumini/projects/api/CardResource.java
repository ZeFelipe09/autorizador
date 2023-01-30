package com.elumini.projects.api;

import com.elumini.projects.domain.Card;
import com.elumini.projects.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cartoes")
public class CardResource {
    @Autowired
    private CardService cardService;

    @PostMapping()
    public ResponseEntity<Card> createCard(@RequestBody Card card){
        Card cardCreated = cardService.createCard(card);
        if(cardCreated == null){
            return ResponseEntity.status(422).body(card);
        }else{
            return ResponseEntity.ok(cardCreated);
        }

    }
}
