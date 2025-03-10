package com.example.calculator.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.Calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CalculatorController {

    @GetMapping("/add") // http://localhost:8080/add?num1=20&num2=40
    public Calculator add(@RequestParam String num1, @RequestParam String num2) {
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        return new Calculator(Integer.toString(result));
    }

    @GetMapping("/sub") // Example: http://localhost:8080/sub?num1=90&num2=10
    public Calculator subtract(@RequestParam String num1, @RequestParam String num2) { 
        int result = Integer.parseInt(num1) - Integer.parseInt(num2);
        return new Calculator(Integer.toString(result));
    }

    @GetMapping("/mul") // http://localhost:8080/mul?num1=5&num2=40
    public Calculator multiply(@RequestParam String num1, @RequestParam String num2) {
        int result = Integer.parseInt(num1) * Integer.parseInt(num2);
        return new Calculator(Integer.toString(result));
    }
}

