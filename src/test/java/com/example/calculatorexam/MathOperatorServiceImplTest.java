package com.example.calculatorexam;
import com.example.calculatorexam.exceptions.InvalidOperationException;
import com.example.calculatorexam.service.MathOperatorImpl;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

@Test
public class MathOperatorServiceImplTest {

    private MathOperatorImpl doMathService=new MathOperatorImpl();
    public void add_success() throws InvalidOperationException {
        double actual=doMathService.doMath(12,13,"+");
        assertEquals(actual,25,"expected 12 + 13 to return 25 instead got "+actual+" ");
    }
    public void divide_success() throws InvalidOperationException {
        double actual=doMathService.doMath(4,2,"/");
        assertEquals(actual,2,"expected 4 / 2 to return 2 instead got "+actual+" ");
    }
    @Test(expectedExceptions = {InvalidOperationException.class})
    public void divide_by_zero() throws InvalidOperationException {
        double actual=doMathService.doMath(12,0,"/");
    }
    public void subtract_success() throws InvalidOperationException {
        double actual=doMathService.doMath(20,13,"-");
        assertEquals(actual,7,"expected 20 - 13 to return 7 instead got "+actual+" ");
    }
    public void multiply_success() throws InvalidOperationException {
        double actual=doMathService.doMath(12,13,"*");
        assertEquals(actual,12*13,"expected 12 + 13 to return 25 instead got "+actual+" ");
    }
    public void log_success() throws InvalidOperationException {
        double actual=doMathService.doMath(12,13,"ln");
        assertEquals(actual,12*Math.log(13),"expected 12 + 13 to return 25 instead got "+actual+" ");
    }
    public void power_success() throws InvalidOperationException {
        double actual=doMathService.doMath(2,4,"**");
        assertEquals(actual,Math.pow(2,4),"expected 2**4 to return 16 instead got "+actual+" ");
    }
}
