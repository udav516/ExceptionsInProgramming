package org.example.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в следующем формате через пробел: ");
        System.out.println("Фамилия Имя Отчество дата рождения номер телефона пол");
        String userData = scanner.nextLine();
        String[] userDataArray = userData.split(" ");
        if (userDataArray.length < 6) {
            throw new smallArraySizeException();
        } else if (userDataArray.length > 6) {
            throw new bigArraySizeException();
        }

        try {
            validateData(userDataArray[0], userDataArray[1], userDataArray[2], userDataArray[3], userDataArray[4], userDataArray[5]);
            saveUserDataToFile(userDataArray[0], userDataArray[1], userDataArray[2], userDataArray[3], userDataArray[4], userDataArray[5]);
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
        if (!lastName.matches("[A-Za-z]+") && !lastName.matches("[А-Яа-я]+")) {
            throw new lastNameException(lastName);
        }
        if (!firstName.matches("[A-Za-z]+") && !firstName.matches("[А-Яа-я]+")) {
            throw new firstNameException(firstName);
        }
        if (!middleName.matches("[A-Za-z]+") && !middleName.matches("[А-Яа-я]+")) {
            throw new middleNameException(middleName);
        }
        if (!dateOfBirth.matches("(((0[1-9]|[12][0-9]|3[01]).((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30).(0[469]|11))" +
                "|(0[1-9]|[1][0-9]|2[0-8]).(02))" +
                ".([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))" +
                "|(29.02.(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))")) {
            throw new dateOfBirthException(dateOfBirth);
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new phoneNumberException(phoneNumber);
        }
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new genderException(gender);
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

class lastNameException extends RuntimeException {
    public lastNameException(String lastName) {
        super("Неверный формат фамилии, " + lastName + " введите буквами.");
    }
}

class firstNameException extends RuntimeException {
    public firstNameException(String firstName) {
        super("Неверный формат имени, " + firstName + " введите буквами.");
    }
}

class middleNameException extends RuntimeException {
    public middleNameException(String middleName) {
        super("Неверный формат отчества, " + middleName + " введите буквами.");
    }
}

class dateOfBirthException extends RuntimeException {
    public dateOfBirthException(String dateOfBirth) {
        super("Неверный формат даты рождения, " + dateOfBirth + " введите dd.mm.yyyy.");
    }
}

class phoneNumberException extends RuntimeException {
    public phoneNumberException(String phoneNumber) {
        super("Неверный формат номера телефона, " + phoneNumber + " введите цифрами.");
    }
}

class genderException extends RuntimeException {
    public genderException(String gender) {
        super("Неверный формат пола, " + gender + " введите f(женский) или m(мужской).");
    }
}

class smallArraySizeException extends RuntimeException {
    public smallArraySizeException() {
        super("Введено меньше данных, чем требуется");
    }
}

class bigArraySizeException extends RuntimeException {
    public bigArraySizeException() {
        super("Введено больше данных, чем требуется");
    }
}