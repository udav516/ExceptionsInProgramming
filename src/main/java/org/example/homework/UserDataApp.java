package org.example.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя в следующем формате: ");
        System.out.println("Иванов Иван Иванович 12.12.2012 79857932846 f(женский)/m(мужской)");
        String userData = scanner.nextLine();
        String[] userDataArray = userData.split(" ");
        if (userDataArray.length < 6) {
            System.out.println("Недостаточно данных");
            return;
        } else if (userDataArray.length > 6) {
            System.out.println("Избыток данных");
            return;
        }
        String lastName = userDataArray[0];
        String firstName = userDataArray[1];
        String middleName = userDataArray[2];
        String dateOfBirth = userDataArray[3];
        String phoneNumber = userDataArray[4];
        String gender = userDataArray[5];

        try {
            validateData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
            saveUserDataToFile(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
            System.out.println("Данные успешно сохранены в файл");
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
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
        if (!lastName.matches("[A-Za-z]+") && !lastName.matches("[А-Яа-я]+") ) {
            throw new IllegalArgumentException("Неверный формат фамилии, введите буквами.");
        }
        if (!firstName.matches("[A-Za-z]+") && !firstName.matches("[А-Яа-я]+")) {
            throw new IllegalArgumentException("Неверный формат имени, введите буквами.");
        }
        if (!middleName.matches("[A-Za-z]+") && !middleName.matches("[А-Яа-я]+")) {
            throw new IllegalArgumentException("Неверный формат отчества, введите буквами.");
        }
        if (!dateOfBirth.matches("(((0[1-9]|[12][0-9]|3[01]).((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30).(0[469]|11))" +
                "|(0[1-9]|[1][0-9]|2[0-8]).(02))" +
                ".([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))" +
                "|(29.02.(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))")) {
            throw new IllegalArgumentException("Неверный формат даты рождения, введите верно dd.mm.yyyy");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Неверный формат номера телефона, введите верно 9857932846");
        }
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new IllegalArgumentException("Неверный формат пола, введите верно f(женский) или m(мужской)");
        }
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
    private static void saveUserDataToFile(String lastName, String firstName, String middleName, String dateOfBirth, String phoneNumber, String gender) throws IOException {
        String fileName = "C:\\Users\\Eldar\\IdeaProjects\\ExceptionsInProgramming\\src\\main\\java\\org\\example\\homework\\dataUser";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender + "\n");
        }
    }
}
