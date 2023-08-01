package org.example;

import java.io.*;
import java.util.*;

public class Seminar2 {
    public static void main(String[] args) {
        String filePatch = "C:\\Users\\Eldar\\IdeaProjects\\ExceptionsInProgramming\\src\\main\\java\\org\\example\\dataInput";
        List<String[]> b = myReader(filePatch);
        b = checkArray(b);
        myWriter(b, filePatch);
    }

    public static List<String[]> myReader(String filePatch) {
        try {
            FileReader fr = new FileReader(filePatch);
            BufferedReader br = new BufferedReader(fr);
            String line;
            List<String[]> book = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] r = line.split("=");
                book.add(r);
            }
            return book;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String[]> checkArray(List<String[]> array) {
        for (String[] item : array) {
            if (item[1].equals("?")) {
                item[1] = String.valueOf(item[0].length());
            }
        }
        return array;
    }

    public static void myWriter(List<String[]> array, String filePatch) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePatch));
            for (String[] item : array) {
                writer.write(item[0] + "=" + item[1] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
