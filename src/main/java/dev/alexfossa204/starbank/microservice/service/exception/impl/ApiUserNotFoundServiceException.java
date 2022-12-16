package dev.alexfossa204.starbank.microservice.service.exception.impl;

import dev.alexfossa204.starbank.microservice.service.exception.ServiceException;

public class ApiUserNotFoundServiceException extends ServiceException {

    public ApiUserNotFoundServiceException() {
    }

    public ApiUserNotFoundServiceException(String message) {
        super(message);
    }

    public ApiUserNotFoundServiceException(Throwable cause) {
        super(cause);
    }

}
