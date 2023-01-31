package com.elumini.projects.service;

import com.elumini.projects.domain.Card;
import com.elumini.projects.domain.Transaction;
import com.elumini.projects.enums.TransactionErrors;
import com.elumini.projects.error.TransactionException;
import com.elumini.projects.repository.CardJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private CardJPA cardRepository;

    public Double createTransaction(Transaction transaction) throws TransactionException {
        Card card = cardRepository.findCardByCardNumber(transaction.getCardNumber());

        System.out.println(card.getPassword());
        System.out.println(transaction.getPassword());

        if (card == null) {
            throw new TransactionException(TransactionErrors.CARTAO_INEXISTENTE.toString());
        }else if (!card.getPassword().equals(transaction.getPassword())) {
            throw new TransactionException(TransactionErrors.SENHA_INVALIDA.toString());
        }else if (transaction.getValue() > card.getBalance().doubleValue()) {
            throw new TransactionException(TransactionErrors.SALDO_INSUFICIENTE.toString());
        } else {
            Double newBalance = card.getBalance().doubleValue() - transaction.getValue();

            card.setBalance(BigDecimal.valueOf(newBalance));

            cardRepository.save(card);
        }
        return card.getBalance().doubleValue();
    }
}
