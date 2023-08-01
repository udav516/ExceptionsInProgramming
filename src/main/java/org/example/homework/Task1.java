package org.example.homework;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        float input = getInputFloat();
        System.out.println("Введенное число: " + input);
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
