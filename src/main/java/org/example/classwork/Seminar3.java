package org.example.classwork;

import java.io.*;
import java.nio.file.*;

public class Seminar3 {
    /**
     * Использование блока try-with-resources
     * @param pathRead считывающий файл
     * @param pathWrite записываемый файл
     * @throws IOException
     */
    public void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }

}

