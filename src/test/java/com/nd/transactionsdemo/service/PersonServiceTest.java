package com.nd.transactionsdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
class PersonServiceTest {
    @Test
    void testSayHello() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        PersonService proxy = (PersonService) enhancer.create();
        String res = proxy.sayHello(null);
    }
}
