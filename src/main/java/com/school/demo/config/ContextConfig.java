package com.school.demo.config;

import com.school.demo.service.AnswerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ContextConfig {

    @Bean
    public AnswerServiceImpl getMultiplesCalculator() {
        return new AnswerServiceImpl();
    }

}
