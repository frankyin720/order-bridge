package com.rw.orderbridge.exception;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {
    public String message;
    
    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable e) {
        super(e);
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
