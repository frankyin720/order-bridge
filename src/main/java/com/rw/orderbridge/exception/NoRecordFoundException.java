package com.rw.orderbridge.exception;

@SuppressWarnings("serial")
public class NoRecordFoundException extends RuntimeException {
    public NoRecordFoundException() {
        super();
    }

    public NoRecordFoundException(String message) {
        super(message);
    }
}
