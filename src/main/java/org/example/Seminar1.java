package org.example;

import java.util.*;

public class Seminar1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int minimumLength1 = 5;
        System.out.println("Array 1 length: " + checkArrayLength(array1, minimumLength1));

        int[] array2 = {4, 5, 6, 7, 8};
        int minimumLength2 = 3;
        System.out.println("Array 2 length: " + checkArrayLength(array2, minimumLength2));

        int[] array = {4, 2, 6, 8, 3, 9, 10};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите искомый элемент: ");
        int desiredValue = scanner.nextInt();

        int index = findIndex(array, desiredValue);

        if (index == -1) {
            System.out.println("Ошибка: длина массива меньше 5");
        } else if (index == -2) {
            System.out.println("Искомый элемент не найден");
        } else if (index == -3) {
            System.out.println("Ошибка: передан null");
        } else {
            System.out.println("Искомый элемент найден в массиве под индексом " + index);
        }
    }

    /**
     * Проверка на размер массива
     * @param array         целочисленный массив
     * @param minimumLength минимальный празмер массива
     * @return код ошибки или размер массива
     */
    public static int checkArrayLength(int[] array, int minimumLength) {
        if (array.length < minimumLength) {
            return -1;
        } else {
            return array.length;
        }
    }

    /**
     * Проверка при поиске заданного значения
     * @param array        целочисленный массив
     * @param desiredValue искомое значение
     * @return код ошибки или индекс искомого значения
     */
    public static int findIndex(int[] array, int desiredValue) {
        if (array == null) {
            return -3;
        }

        if (array.length < 5) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == desiredValue) {
                return i;
            }
        }

        return -2;
    }
}