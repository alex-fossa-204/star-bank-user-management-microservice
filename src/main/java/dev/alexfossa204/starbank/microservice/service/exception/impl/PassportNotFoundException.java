package dev.alexfossa204.starbank.microservice.service.exception.impl;

import dev.alexfossa204.starbank.microservice.service.exception.ServiceException;

public class PassportNotFoundException extends ServiceException {

    public PassportNotFoundException() {
    }

    public PassportNotFoundException(String message) {
        super(message);
    }

    public PassportNotFoundException(Throwable cause) {
        super(cause);
    }
}
