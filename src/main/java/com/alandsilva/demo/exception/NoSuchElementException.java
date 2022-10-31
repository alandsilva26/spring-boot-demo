package com.alandsilva.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {
        super("No such element present.");
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
