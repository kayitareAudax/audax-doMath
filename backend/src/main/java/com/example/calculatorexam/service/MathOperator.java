package com.example.calculatorexam.service;

import com.example.calculatorexam.exceptions.InvalidOperationException;
import org.springframework.stereotype.Service;

@Service
public interface MathOperator {
    public double doMath(double operand1,double operand2,String operation) throws InvalidOperationException;
}
