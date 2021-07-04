package com.school.demo.service;


import com.school.demo.config.ContextConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ContextConfig.class})
class AnswerServiceImplTest {

    @Autowired
    AnswerServiceImpl answerServiceImpl;

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21, 99})
    @DisplayName("Fizz numbers test")
    void testFizzNumbers(int fizzNumber) {
        assertEquals("Fizz", answerServiceImpl.applyFizzBuzzRule(fizzNumber),
                "Fizz: Multiple of 3 but not multiple of 5");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 50, 100})
    @DisplayName("Buzz numbers test")
    void testBuzzNumbers(int buzzNumber) {
        assertEquals("Buzz", answerServiceImpl.applyFizzBuzzRule(buzzNumber),
                "Buzz: Multiple of 5 but not multiple of 3");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75})
    @DisplayName("FizzBuzz numbers test")
    void testFizzBuzzNumbers(int fizzBuzzNumber) {
        assertEquals("FizzBuzz", answerServiceImpl.applyFizzBuzzRule(fizzBuzzNumber),
                "FizzBuzz: Multiple of both 3 and 5");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 8, 11, 97})
    @DisplayName("Numbers test")
    void testNumbers(int number) {
        assertEquals(Integer.toString(number), answerServiceImpl.applyFizzBuzzRule(number),
                "Number: not Fizz, not Buzz, not FizzBuzz then its same number");
    }

    @ParameterizedTest
    @MethodSource("range")
    @DisplayName("1 to 100 range: Fizz or Buzz or FizzBuzz or number")
    void testRange1To100(int number) {
        assertThat(answerServiceImpl.applyFizzBuzzRule(number)).isIn("Fizz", "Buzz", "FizzBuzz", Integer.toString(number));
    }

    static Stream<Integer> range() {
        return IntStream.rangeClosed(1, 100).boxed();
    }
}
