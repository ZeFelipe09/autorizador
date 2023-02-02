package com.elumini.projects.api;

import com.elumini.projects.domain.Transaction;
import com.elumini.projects.error.TransactionException;
import com.elumini.projects.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransactionResources {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction){
        transactionService.createTransaction(transaction);
        return ResponseEntity.ok().body("OK");
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<String> exception(TransactionException err){
        return ResponseEntity.status(422).body(err.getMessage());
    }
}
