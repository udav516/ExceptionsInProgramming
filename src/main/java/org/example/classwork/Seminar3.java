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

