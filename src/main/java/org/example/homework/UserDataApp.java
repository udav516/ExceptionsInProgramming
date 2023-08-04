package org.example.homework;

import java.util.*;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя в следующем формате: ");
        System.out.println("Иванов Иван Иванович 12.12.2012 79857932846 f(женский)/m(мужской)");
        String userData = scanner.nextLine();
        String[] userDataArray = userData.split(" ");
        if (userDataArray.length != 6) {
        }
        String lastName = userDataArray[0];
        String firstName = userDataArray[1];
        String middleName = userDataArray[2];
        String dateOfBirth = userDataArray[3];
        String phoneNumber = userDataArray[4];
        String gender = userDataArray[5];

        try {

        } catch () {

        }
    }

    /**
     * Проверка введённых данных пользователя
     * @param lastName    фамилия
     * @param firstName   имя
     * @param middleName  отчество
     * @param dateOfBirth дата рождения
     * @param phoneNumber номер телефона
     * @param gender      пол
     */
    private static void validateData(String lastName, String firstName, String middleName, String dateOfBirth, String phoneNumber, String gender) {

    }

    /**
     * Сохранение полученных данных пользователя в файл
     * @param lastName    фамилия
     * @param firstName   имя
     * @param middleName  отчество
     * @param dateOfBirth дата рождения
     * @param phoneNumber номер телефона
     * @param gender      пол
     */
    private static void saveUserDataToFile(String lastName, String firstName, String middleName, String dateOfBirth, String phoneNumber, String gender) {

    }
}
