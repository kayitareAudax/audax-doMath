package com.example.calculatorexam.service;

import com.example.calculatorexam.exceptions.InvalidOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathOperatorImpl implements MathOperator{
    @Override
    public double doMath(double operand1,double operand2,String operation) throws InvalidOperationException {
        if("/".equals(operation) && operand2==(double)0){
            throw  new InvalidOperationException("can not divide by 0");
        }
        switch (operation){
            case  "*":
                return operand1*operand2;
            case  "/":
                return operand1/operand2;
            case "+":
                return  operand1+operand2;
            case "-":
                return  operand1-operand2;
            case "**":
                return  Math.pow(operand1,operand2);
            case "ln":
                return  operand1 *Math.log(operand2);
            default:
                throw  new RuntimeException("unknown operation");
        }
    }
}
