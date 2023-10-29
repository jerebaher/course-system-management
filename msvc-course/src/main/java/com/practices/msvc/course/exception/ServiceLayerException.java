package com.practices.msvc.course.exception;

import com.practices.msvc.course.message.ErrorMessages;

public class ServiceLayerException extends Exception {
    public ServiceLayerException(String message) {
        super(message);
    }

    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceLayerException(ErrorMessages errorMessage) {
        super(errorMessage.getValue());
    }
}
