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

        /**
         * Задание 3
         * public static void main(String[] args) throws Exception {
         *    try {
         *        int a = 90;
         *        int b = 3;
         *        System.out.println(a / b);
         *        printSum(23, 234);
         *        int[] abc = { 1, 2 };
         *        abc[3] = 9;
         *    } catch (Throwable ex) {
         *        System.out.println("Что-то пошло не так...");
         *    } catch (NullPointerException ex) {
         *        System.out.println("Указатель не может указывать на null!");
         *    } catch (IndexOutOfBoundsException ex) {
         *        System.out.println("Массив выходит за пределы своего размера!");
         *    }
         * }
         * public static void printSum(Integer a, Integer b) throws FileNotFoundException {
         *    System.out.println(a + b);
         * }
         * Исправить код
         */
//    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Индекс выходит за пределы массива!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
//    }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("Пустые строки вводить нельзя!");
        }
        System.out.println("Введенная строка: " + input);
        scanner.close();
    }

    /**
     * Сложение чисел
     * @param a первое число
     * @param b второе число
     */
    public static void printSum(int a, int b) {
        System.out.println(a + b);
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
