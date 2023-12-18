package com.nd.transactionsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TransactionsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionsDemoApplication.class, args);
    }

}
