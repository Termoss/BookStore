package com.termos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(StartBookApplication.class, args);
    }

    /* run this only on profile 'demo', avoid run this in test */

}