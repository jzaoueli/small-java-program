package bla.reader;

import java.io.*;

import bla.reader.base.Strategy;

/**
 * Task: get numbers from InputStream , calculate and show the sum
 */
public class CalculateStrategy implements Strategy {

    public void algorithm(InputStream inputStream) {
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
        System.out.println("the final sum = " + sum);
    }
}
