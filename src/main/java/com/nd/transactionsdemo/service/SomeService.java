package com.nd.transactionsdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SomeService {
    @Transactional
    public void someMethod() {
//        anotherMethod();
        throw new RuntimeException("Exception in someMethod");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void anotherMethod() {

    }

    public void theOtherMethod() {

    }

    public void saySome() {
        log.info("Some");
    }
}
