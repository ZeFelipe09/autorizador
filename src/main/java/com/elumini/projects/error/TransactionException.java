package com.elumini.projects.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
@ResponseBody
public class TransactionException extends RuntimeException{
    public TransactionException(String message){
        super(message);
    }
}
