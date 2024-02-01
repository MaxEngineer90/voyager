package com.ml.voyager.exceptions;

public class NotADirectoryException extends IllegalArgumentException {
    public NotADirectoryException(String message) {
        super(message);
    }
}