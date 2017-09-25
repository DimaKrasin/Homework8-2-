package com.goit.homework;

import java.io.*;

public class ReadWriteDelete {
    public static void writeToFile(String string, String path) throws IOException {
        System.out.println("Saving data");
        FileWriter writer = new FileWriter(path, true);
        writer.write(string);
        writer.write("\n");
        writer.flush();
        writer.close();
    }

    public static String read(String path) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void DeleteAllData(String path) throws IOException {
        System.out.println("Delete data");
        FileWriter writer = new FileWriter(path);
        writer.write("");
        writer.flush();
        writer.close();
    }
}
