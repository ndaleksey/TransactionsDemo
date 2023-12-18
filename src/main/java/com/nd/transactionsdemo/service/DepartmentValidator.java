package com.nd.transactionsdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Slf4j
@Component
public class DepartmentValidator {
    @Transactional(noRollbackFor = ArithmeticException.class)
    public void validateName(String name) {
        log.info("Try to validate department");

        if (!StringUtils.hasText(name)) {
            log.warn("Validation error");
            throw new IllegalArgumentException("Department Name is null or empty");
        }
    }
}
