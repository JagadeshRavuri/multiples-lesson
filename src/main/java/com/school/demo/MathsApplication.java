package com.school.demo;

import com.school.demo.service.AnswerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.stream.IntStream.rangeClosed;

@SpringBootApplication
public class MathsApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory
            .getLogger(MathsApplication.class);
    @Autowired
    AnswerServiceImpl answerServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(MathsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("Printing answers as Fizz, Buzz or number from 1 to 100...");

        rangeClosed(1, 100).forEach(i -> logger.info(answerServiceImpl.applyFizzBuzzRule(i)));

        logger.info("Successfully finished printing answers...");
    }

}
