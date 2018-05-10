package com.rw.orderbridge.exception;

@SuppressWarnings("serial")
public class MultipleRecordFoundException extends RuntimeException {
    public MultipleRecordFoundException() {
        super();
    }

    public MultipleRecordFoundException(String message) {
        super(message);
    }

}
