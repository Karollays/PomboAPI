package com.fiap.pombo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EventoNaoExisteException extends RuntimeException {
    public EventoNaoExisteException(String message) {
        super(message);
    }
}

