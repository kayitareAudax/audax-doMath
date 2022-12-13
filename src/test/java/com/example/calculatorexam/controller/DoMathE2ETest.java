package com.example.calculatorexam.controller;

import com.example.calculatorexam.model.DoMathRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.testng.AssertJUnit.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoMathE2ETest {
    @Autowired
    private TestRestTemplate restTemplate;
    private JSONObject doMathObject = new JSONObject();
    private final ObjectMapper objectMapper = new ObjectMapper();
//    private  HttpHeaders headers;
    @Test
    public void testMath() throws JSONException {
        DoMathRequest doMathRequest1=new DoMathRequest(12,12,"+");
//        this.restTemplate.postForEntity("/math",doMathRequest1)
        doMathObject.put("operand1", 1);
        doMathObject.put("operand2", 3);
        doMathObject.put("operation", "*");
        Double doMathResult =
                restTemplate.postForObject("/math", doMathObject, Double.class);
        assertEquals(String.valueOf(Double.valueOf(doMathResult)),Double.valueOf(3),false);
    }
}
