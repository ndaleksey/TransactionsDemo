package com.nd.transactionsdemo.exception.handler;

import com.nd.transactionsdemo.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public String handleApplicationException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return e.getMessage();
    }
}
