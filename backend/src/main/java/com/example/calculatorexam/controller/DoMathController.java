package com.example.calculatorexam.controller;

import com.example.calculatorexam.exceptions.InvalidOperationException;
import com.example.calculatorexam.model.DoMathRequest;
import com.example.calculatorexam.service.MathOperatorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api")
@RequiredArgsConstructor

public class DoMathController {
    @Autowired
    private MathOperatorImpl doMathService;

    public DoMathController(MathOperatorImpl doMathService) {
        this.doMathService = doMathService;
    }
    @CrossOrigin
    @PostMapping("/math")
    public ResponseEntity<Double> doMath(@RequestBody DoMathRequest doMathRequest) throws InvalidOperationException {
        doMathService.doMath(doMathRequest.getOperand1(),doMathRequest.getOperand2(),doMathRequest.getOperation());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(doMathService.doMath(doMathRequest.getOperand1(),doMathRequest.getOperand2(),doMathRequest.getOperation()));
    }
}
