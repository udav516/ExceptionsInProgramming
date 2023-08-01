package org.example.homework;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Пустые строки вводить нельзя!");
        }
        System.out.println("Введенная строка: " + input);
        scanner.close();
    }
}
