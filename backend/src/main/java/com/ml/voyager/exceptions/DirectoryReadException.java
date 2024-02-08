package com.ml.voyager.exceptions;

public class DirectoryReadException extends RuntimeException {
    public DirectoryReadException(String message, Throwable cause) {
        super(message, cause);
    }
}