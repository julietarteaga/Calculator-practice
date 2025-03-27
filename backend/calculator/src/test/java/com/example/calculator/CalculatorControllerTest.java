package com.example.calculator;

import com.example.calculator.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAdd() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/add?num1=5.0&num2=3.0", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        double result = Double.parseDouble(response.getBody().result());
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testAddWithDefaultValues() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/add", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        double result = Double.parseDouble(response.getBody().result());

        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testSub() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/sub?num1=5.0&num2=3.0", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        double result = Double.parseDouble(response.getBody().result());
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testSubWithDefaultValues() {
        ResponseEntity<Calculator> response = restTemplate.getForEntity("/sub", Calculator.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        double result = Double.parseDouble(response.getBody().result());
        assertEquals(0.0, result, 0.001);
    }
}