package examples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Class name should be anything, but it should have "Test" keyword before or after class Name
public class CalculatorTest {
    Calculator cal = new Calculator();

    @Test
    public void addition() {

        int result = cal.add(10, 5);
        System.out.println(result);
    }

    @Test
    public void multiply() {
        int result = cal.multiply(10, 5);
        System.out.println(result);
    }
    @RepeatedTest(4)
    public void repeatedAdditionTest() {
        int num1 = new Random().nextInt(10);
        int num2 = new Random().nextInt(10);
        int result = cal.add(num1,num2);
        System.out.println("Sum is: " + result);
    }
    @ParameterizedTest
    @ValueSource(ints ={10,-5, 0})
    public void squareTest(int num1){
        int result= cal.square(num1);
        System.out.println("Input is " + num1);
        System.out.println("Output is " + result);
        System.out.println("..........................");

        //Assertions

        assertEquals(num1*num1, result);
        assertTrue(result>=0);
    }
}
