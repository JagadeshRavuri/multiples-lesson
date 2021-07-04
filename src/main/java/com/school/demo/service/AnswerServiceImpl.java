package com.school.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    public String applyFizzBuzzRule(int i) {

        if (i % 3 == 0 && i % 5 == 0)
            return FIZZBUZZ;
        else if (i % 3 == 0)
            return FIZZ;
        else if (i % 5 == 0)
            return BUZZ;

        return Integer.toString(i);
    }


}

