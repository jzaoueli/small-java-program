package bla.test2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import bla.test2.base.Strategy;

/**
 * Aufgabe: calculate and show
 */
public class CalculateStrategy implements Strategy {

    public void algorithmus(String fileName) {
        String line = "";
        int sum = 0;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            bufferReader.readLine();
            while ((line = bufferReader.readLine()) != null) {
                sum = sum + Integer.valueOf(line);
            }
            bufferReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ;
        System.out.println("the final sum =" + sum);
    }
}
