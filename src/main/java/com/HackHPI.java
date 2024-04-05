package com;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HackHPI {
    private Logger logger = Logger.getLogger("BeAWinH.java");

    public static void main(String[] args) {
        SpringApplication.run(HackHPI.class, args);
    }
}
