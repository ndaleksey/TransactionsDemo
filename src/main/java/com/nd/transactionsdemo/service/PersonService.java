package com.nd.transactionsdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Service
public class PersonService {
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}
