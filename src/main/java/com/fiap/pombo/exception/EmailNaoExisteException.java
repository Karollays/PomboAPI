package com.fiap.pombo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailNaoExisteException extends RuntimeException {
    public EmailNaoExisteException(String mensagem) {
        super(mensagem);
    }
}
