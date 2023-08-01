package org.example.homework;

public class Task2 {
    public static void main(String[] args) {
        /**
         * Задание 2
         * try {
         *    int d = 0;
         *    double catchedRes1 = intArray[8] / d;
         *    System.out.println("catchedRes1 = " + catchedRes1);
         * } catch (ArithmeticException e) {
         *    System.out.println("Catching exception: " + e);
         * }
         * Исправить код
         */
        try {
            int d = 3;
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            double catchRes1 = (double) intArray[8] / d;
            System.out.println("catchRes1 = " + catchRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
