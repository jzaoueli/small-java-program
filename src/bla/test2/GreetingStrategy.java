package bla.test2;

import java.io.*;

import bla.test2.base.Strategy;

/**
 * Aufgabe: read names and show
 */
public class GreetingStrategy implements Strategy {

    /**
     * @param inputStream
     */

    public void algorithmus(InputStream inputStream) {
        String line;
        try {
            System.out.println("+++++++++++++++++GreetingStrategy++++++++++++++++++++++");
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((line = bufferReader.readLine()) != null) {
                System.out.println("Hallo " + line);
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
