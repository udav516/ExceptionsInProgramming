package org.example.classwork;

import java.io.*;
import java.nio.file.*;

public class Seminar3 {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (Counter counter = new Counter()) {
            counter.add();
            System.out.println(counter.getA());
            counter.close();
            counter.add();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int n = 7;
        String[] array = {"hello", "goodbye", null, "ok", "error"};
        String file = "dataFile";

        try {
            int b = n / 0;
            System.out.println(b);
        } catch (ArithmeticException e) {
            try {
                throw new DivisionByZeroException();
            } catch (DivisionByZeroException ex) {
                System.out.println(ex.getMessage());
            }
        }
        int i = 0;
        try {
            for (; i < array.length; i++) {
                System.out.println(array[i].length());
            }
        } catch (NullPointerException e) {
            try {
                throw new myNullPointerException(i);
            } catch (myNullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }

        try (FileReader fr = new FileReader(file)) {
            fr.read();
        } catch (FileNotFoundException e) {
            try {
                throw new myFileNotFoundExeption(file);
            } catch (myFileNotFoundExeption ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public static void doSomething() throws Exception {

    }

    /**
     * Использование блока try-with-resources
     * @param pathRead  считывающий файл
     * @param pathWrite записываемый файл
     * @throws IOException ошибка при выводе/вводе данных
     */
    public void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }

}

class Counter implements AutoCloseable {
    private int a;

    public Counter() {
        this.a = 0;
    }

    public int getA() {
        return a;
    }

    public void add() throws IOException {
        if (isClosed()) {
            throw new IOException("Объект закрыт");
        }
        this.a++;
    }

    public boolean isClosed() {
        return a < 0;
    }

    @Override
    public void close() {
        this.a = -1;
        System.out.println("Method close is closed");
    }
}

class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super("Деление на ноль запрещено!");
    }
}

class myNullPointerException extends NullPointerException {
    public myNullPointerException(int i) {
        super("Элемент " + i + " отсутствует!");
    }
}

class myFileNotFoundExeption extends FileNotFoundException {
    public myFileNotFoundExeption(String path) {
        super("Данный файл по адресу " + path + " не найден!");
    }
}

