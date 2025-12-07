package com.example.springcdsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCdsDemo {

    public static void main(String[] args) {
        long start = System.nanoTime();
        SpringApplication.run(SpringCdsDemo.class, args);
        long elapsed = System.nanoTime() - start;
        System.out.println("Spring Boot démarré en " + (elapsed / 1_000_000) + " ms");
    }
}
