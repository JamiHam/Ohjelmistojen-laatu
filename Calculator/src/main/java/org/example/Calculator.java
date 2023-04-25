package org.example;

public class Calculator {
    private int sum;

    public Calculator() {
        sum = 0;
    }

    public void reset() {
        sum = 0;
    }

    // Adds the given integer to the value. Throws an exception if the given integer is negative.
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The given number must be positive.");
        }
        sum += number;
    }

    public int getSum() {
        return sum;
    }
}
