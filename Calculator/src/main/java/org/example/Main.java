package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(5);
        calculator.add(10);

        System.out.println(calculator.getSum());
        calculator.reset();
        System.out.println(calculator.getSum());

        View.main(args);
    }
}