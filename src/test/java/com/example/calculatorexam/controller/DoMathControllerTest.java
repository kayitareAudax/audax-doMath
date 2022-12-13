package com.example.calculatorexam.controller;

import com.example.calculatorexam.model.DoMathRequest;
import com.example.calculatorexam.service.MathOperatorImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DoMathControllerTest {
    DoMathRequest doMathRequest=new DoMathRequest(12,12,"+");
    @MockBean
    @Autowired
    private MathOperatorImpl mathOperator;
    @Autowired
    private MockMvc mockMvc;
   @Test
    public void doMath_success() throws Exception {
       DoMathRequest doMathRequest1=new DoMathRequest(12,12,"+");
       ResponseEntity.status(HttpStatus.ACCEPTED).body(doMathRequest1);
       ObjectMapper mapper=new ObjectMapper();
       mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
       ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
       String requestJson=ow.writeValueAsString(doMathRequest1);
       mockMvc.perform(post("/math").contentType(APPLICATION_JSON_UTF8)
                       .content(requestJson))
               .andExpect(status().isAccepted());
   }
}
