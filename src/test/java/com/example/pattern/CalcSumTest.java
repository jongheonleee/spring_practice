package com.example.pattern;

import static org.junit.jupiter.api.Assertions.*;

import com.example.pattern.template.Calculator;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = {Calculator.class})
class CalcSumTest {

    private static final String FILEPATH = "/Users/qwefghnm1212/Desktop/spring-practice/src/main/java/com/example/pattern/numbers.txt";
    private Calculator target;

    @BeforeEach
    public void setUp() {
        target = new Calculator();
    }

    @Test
    @DisplayName("test1 - sum of numbers in file")
    public void test1() throws IOException {
        assertEquals(target.calcSum(FILEPATH), 10);
    }

    @Test
    @DisplayName("test2 - multiply of numbers in file")
    public void test2() throws IOException {
        assertEquals(target.calcMultiply(FILEPATH), 24);
    }

    @Test
    @DisplayName("test3 - concatenate of numbers in file")
    public void test3() throws IOException {
        assertEquals(target.concatenate(FILEPATH), "1234");
    }


}