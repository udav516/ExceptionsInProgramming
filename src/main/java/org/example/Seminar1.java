package org.example;

public class Seminar1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int minimumLength1 = 5;
        System.out.println("Array 1 length: " + checkArrayLength(array1, minimumLength1));

        int[] array2 = {4, 5, 6, 7, 8};
        int minimumLength2 = 3;
        System.out.println("Array 2 length: " + checkArrayLength(array2, minimumLength2));
    }

    /**
     * Проверка на размер массива
      * @param array целочисленный массив
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
}