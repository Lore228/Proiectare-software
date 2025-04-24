package ro.ulbs.paradigme.lab7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.paradigme.lab6.DoubleCalculator;

public class DoubleCalculatorTest {
    private DoubleCalculator doubleCalculator;
    @BeforeEach
    public void setUp() {
        doubleCalculator=new DoubleCalculator(0.0);
    }
    @Test
    public void testAddPositive() {
        //arrange
        //act
        doubleCalculator.add(5.5);
        //assert
        Assertions.assertEquals(5.5,doubleCalculator.result());

    }
    @Test
    public void testAddNegatives() {
        //arrange
        //act
        doubleCalculator.add(-10.2);
        //assert
        Assertions.assertEquals(-10.2,doubleCalculator.result());
    }
    @Test
    public void testSubtractPositives() {
        //arrange
        //act
        doubleCalculator.subtract(2.6);
        //assert
        Assertions.assertEquals(-2.6,doubleCalculator.result());
    }
    @Test
    public void testSubtractNegatives() {
        //arrange
        //act
        doubleCalculator.subtract(-4.8);
        //assert
        Assertions.assertEquals(4.8,doubleCalculator.result());
    }
    @Test
    public void testMultiplyPositives() {
        //arrange
        doubleCalculator.add(5.0);
        //act
        doubleCalculator.multiply(2.0);
        //assert
        Assertions.assertEquals(10.0,doubleCalculator.result());
    }
    @Test
    public void testMultiplyNegatives() {
        //arrange
        doubleCalculator.add(-3.0);
        //act
        doubleCalculator.multiply(-4.0);
        //assert
        Assertions.assertEquals(12.0,doubleCalculator.result());
    }
    @Test
    public void testMultiplyBy0() {
        //arrange
        doubleCalculator.add(10.0);
        //act
        doubleCalculator.multiply(0.0);
        //assert
        Assertions.assertEquals(0.0,doubleCalculator.result());
    }
    @Test
    public void testDividePositives() {
        //arrange
        doubleCalculator.add(10.0);
        //act
        double result=doubleCalculator.result()/2.5;
        //assert
        Assertions.assertEquals(4.0,result);
    }
    @Test
    public void testDivideNegatives() {
        //arrange
        doubleCalculator.add(-10.0);
        //act
        double result=doubleCalculator.result()/2.5;
        //assert
        Assertions.assertEquals(-4.0,result);
    }
    @Test
    public void testDivideBy0() {
        doubleCalculator.add(10.0);
        double result = doubleCalculator.result() / 0.0;
        Assertions.assertTrue(Double.isInfinite(result));
    }
    @AfterEach
    public void tearDown() {
        doubleCalculator = null;
    }
}