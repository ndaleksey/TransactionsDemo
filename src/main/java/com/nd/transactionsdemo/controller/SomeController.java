package com.nd.transactionsdemo.controller;

import com.nd.transactionsdemo.service.SomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class SomeController {
    private final SomeService someService;

    @Transactional
    @GetMapping("/some")
    public void someMethod() {
        try {
            someService.someMethod();
        } catch (Exception e) {
            log.error("Cannot proceed due to errors: {}", e.getMessage());
        }

        log.info("Finish");

//        someService.saySome();
    }
}
