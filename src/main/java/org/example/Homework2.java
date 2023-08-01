package org.example;

import java.util.*;

public class Homework2 {
    public static void main(String[] args) {
        float input = getInputFloat();
        System.out.println("Введенное число: " + input);

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
//            int d = 0;
            int d = 3;
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            double catchRes1 = (double) intArray[8] / d;
            System.out.println("catchRes1 = " + catchRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    /**
     * Проверка на ввод дробного числа(типа float)
     * @return дробное число
     */
    public static float getInputFloat() {
        Scanner scanner = new Scanner(System.in);
        float input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                input = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Повторите попытку.");
            }
        }

        return input;
    }
}
