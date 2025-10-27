package com.example;

/**
 * Simple Java application for CI/CD demonstration
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello from Java CI/CD Demo!");

        Calculator calculator = new Calculator();
        System.out.println("Calculator Test: 5 + 3 = " + calculator.add(5, 3));
        System.out.println("Calculator Test: 10 - 4 = " + calculator.subtract(10, 4));
        System.out.println("Calculator Test: 6 * 7 = " + calculator.multiply(6, 7));
        System.out.println("Calculator Test: 20 / 4 = " + calculator.divide(20, 4));
    }

    public String getGreeting() {
        return "Hello from Java CI/CD Demo!";
    }
}
