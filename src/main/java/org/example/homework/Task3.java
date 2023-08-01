package org.example.homework;

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
public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2, 3, 4};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    /**
     * Сложение чисел
     * @param a первое число
     * @param b второе число
     */
    public static void printSum(Integer a, Integer b) throws ArithmeticException {
        System.out.println(a + b);
    }
}
