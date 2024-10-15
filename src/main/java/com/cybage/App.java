package com.cybage;

/**
 * Hello world!
 *
 */
public class App 
{
    public boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input shouldn't be null");
        }
        return input.equals(reverse(input));
    }

    // Calculator methods

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    private String reverse(String input) {
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }
        return rev;
    }
    
    // Uncomment if needed for testing
    // public static void main(String[] args) {
    //     System.out.println("Hello World!");
    // }
}
