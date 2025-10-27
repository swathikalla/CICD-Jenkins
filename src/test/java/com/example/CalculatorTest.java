package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Comprehensive unit tests for Calculator class
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddPositiveNumbers() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    public void testAddNegativeNumbers() {
        assertEquals(-8, calculator.add(-5, -3));
    }

    @Test
    public void testAddZero() {
        assertEquals(5, calculator.add(5, 0));
    }

    @Test
    public void testSubtractPositiveNumbers() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    public void testSubtractNegativeNumbers() {
        assertEquals(-2, calculator.subtract(-5, -3));
    }

    @Test
    public void testMultiplyPositiveNumbers() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        assertEquals(15, calculator.multiply(-5, -3));
    }

    @Test
    public void testDividePositiveNumbers() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
    }

    @Test
    public void testDivideWholeNumber() {
        assertEquals(5.0, calculator.divide(20, 4), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }

    @Test
    public void testIsEvenTrue() {
        assertTrue("4 should be even", calculator.isEven(4));
    }

    @Test
    public void testIsEvenFalse() {
        assertFalse("5 should be odd", calculator.isEven(5));
    }

    @Test
    public void testIsEvenZero() {
        assertTrue("0 should be even", calculator.isEven(0));
    }

    @Test
    public void testIsPrimeTrue() {
        assertTrue("7 is a prime number", calculator.isPrime(7));
        assertTrue("13 is a prime number", calculator.isPrime(13));
    }

    @Test
    public void testIsPrimeFalse() {
        assertFalse("4 is not a prime number", calculator.isPrime(4));
        assertFalse("1 is not a prime number", calculator.isPrime(1));
    }

    @Test
    public void testIsPrimeNegative() {
        assertFalse("Negative numbers are not prime", calculator.isPrime(-5));
    }
}
