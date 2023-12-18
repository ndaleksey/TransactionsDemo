package com.nd.transactionsdemo.exception;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
public class ApplicationException extends RuntimeException{
    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
