package com.project.error;

public class NotEnoughFreePlaceException extends Throwable {
    public NotEnoughFreePlaceException(String notEnoughPlace) {
        super(notEnoughPlace);
    }
}
