package bla.reader;

import java.io.*;

import bla.reader.base.Strategy;

/**
 * Aufgabe: calculate and show
 */
public class CalculateStrategy implements Strategy {

    public void algorithmus(InputStream inputStream) {
        String line;
        int sum = 0;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            System.out.println("+++++++++++++++++CalculateStrategy++++++++++++++++++++++");
            while ((line = bufferReader.readLine()) != null) {
                sum = sum + Integer.valueOf(line);
            }
            bufferReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("the final sum =" + sum);
    }
}