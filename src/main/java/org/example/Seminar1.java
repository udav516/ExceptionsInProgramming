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

        int[][] matrix1 = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        int sum1 = calculateSum(matrix1);
        System.out.println("Сумма элементов: " + sum1);

        int[][] matrix2 = {{1, 0, 2}, {0, 1, 0}, {1, 0, 1}};
        try {
            int sum2 = calculateSum(matrix2);
            System.out.println("Сумма элементов: " + sum2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        /*
          Использование исключений позволяет выделить и обработать ошибки в одном месте,
          а не вносить коды ошибок в результаты методов
          и делать проверку на каждый возможный код ошибки в вызывающем коде.
         */
        try {
            Integer[] arr = {1, null, 3, null, 5};
            checkArray(arr);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        int[] arrayOne = {1, 2, 3};
        int[] arrayTwo = {4, 5, 6};

        try {
            int[] result = sumArrays(arrayOne, arrayTwo);
            for (int i = 0; i < result.length; i++) {
                System.out.println("Сумма элементов на позиции " + i + ": " + result[i]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        int[][] arrayFirst = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        checkLength(arrayFirst);
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

    /**
     * Сумма элементов массива
     * @param matrix целочисленный двумерный массив
     * @return сумма элементов
     */
    public static int calculateSum(int[][] matrix) {
        if (matrix == null) {
            throw new RuntimeException("Ошибка: передан null");
        }

        int n = matrix.length;
        int m = matrix[0].length;

        if (n != m) {
            throw new RuntimeException("Ошибка: массив не является квадратным");
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    throw new RuntimeException("Ошибка: значение в ячейке не равно 0 или 1");
                }
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    /**
     * Проверка на неравенство null
     * @param arr целочисленный одномерный массив
     */
    public static void checkArray(Integer[] arr) {
        StringBuilder isNull = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                isNull.append(i).append(" ");
                System.out.println("Ошибка: в массиве найден null в ячейке \u001B[31m#" + i + "\u001B[0m");
            }
        }
        if (isNull.length() > 1) {
            throw new RuntimeException("Ошибка: встречается значение null: " + isNull);
        }
    }

    /**
     *Сумма масивов с проверкой на неравенство длины массивов
     * @param array1 целочисленный массив
     * @param array2 целочисленный массив
     * @return сумма массивов по индексам
     */
    public static int[] sumArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Ошибка: длины массивов не равны");
        }

        int[] result = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] + array2[i];
        }

        return result;
    }

    /**
     * Проверка на равенство длины строк и столбцов в двумерном массиве
     * @param array двумерный массив
     */
    public static void checkLength(int[][] array) {
        List<String> mismatchedIndices = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length != array[j].length) {
                    mismatchedIndices.add("(" + i + ", " + j + ")");
                }
            }
        }

        if (mismatchedIndices.isEmpty()) {
            System.out.println("Длины строк и столбцов с одинаковым индексом одинаковы.");
        } else {
            System.out.println("Длины строк и столбцов с одинаковым индексом не одинаковы:");

            for (String indices : mismatchedIndices) {
                System.out.println(indices);
            }
        }
    }
}