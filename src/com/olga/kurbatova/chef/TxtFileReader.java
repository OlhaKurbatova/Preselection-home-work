package com.olga.kurbatova.chef;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class TxtFileReader {

    public static void writeToFile(String data, String fileName) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)));

        writer.write(data);
        writer.write("\n");
        writer.flush();
    }

    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Greetings"));) {
            String temp;
            String result = "";
            while ((temp = reader.readLine()) != null) {
                result += temp + "\n";
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





