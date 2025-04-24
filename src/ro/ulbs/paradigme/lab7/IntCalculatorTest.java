package ro.ulbs.paradigme.lab7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.paradigme.lab6.DoubleCalculator;
import ro.ulbs.paradigme.lab6.NewIntCalculator;

public class IntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator=new NewIntCalculator(0);
    }
    @Test
    public void testAddPositive() {
        //arrange
        //act
        calculator.add(5);
        //assert
        Assertions.assertEquals(5,calculator.result());

    }
    @Test
    public void testAddNegatives() {
        //arrange
        //act
        calculator.add(-10);
        //assert
        Assertions.assertEquals(-10,calculator.result());
    }
    @Test
    public void testSubtractPositives() {
        //arrange
        //act
        calculator.subtract(2);
        //assert
        Assertions.assertEquals(-2,calculator.result());
    }
    @Test
    public void testSubtractNegatives() {
        //arrange
        //act
        calculator.subtract(-4);
        //assert
        Assertions.assertEquals(4,calculator.result());
    }
    @Test
    public void testMultiplyPositives() {
        //arrange
        calculator.add(3);
        //act
        calculator.multiply(2);
        //assert
        Assertions.assertEquals(6,calculator.result());
    }
    @Test
    public void testMultiplyNegatives() {
        //arrange
        calculator.add(-3);
        //act
        calculator.multiply(-4);
        //assert
        Assertions.assertEquals(12,calculator.result());
    }
    @Test
    public void testMultiplyBy0() {
        //arrange
        calculator.add(10);
        //act
        calculator.multiply(0);
        //assert
        Assertions.assertEquals(0,calculator.result());
    }
    @Test
    public void testDividePositives() {
        //arrange
        calculator.add(10);
        //act
        int result=calculator.result()/2;
        //assert
        Assertions.assertEquals(5,result);
    }
    @Test
    public void testDivideNegatives() {
        //arrange
        calculator.add(-10);
        //act
        int result=calculator.result()/2;
        //assert
        Assertions.assertEquals(-5,result);
    }
    @Test
    public void testDivideBy0() {
        calculator.add(10);
        Assertions.assertThrows(ArithmeticException.class, () ->{
            int result=calculator.result()/0;
        });
    }
    @AfterEach
    public void tearDown() {
        calculator = null;

    }
}

