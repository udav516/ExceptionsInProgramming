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

