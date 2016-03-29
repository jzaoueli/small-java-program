package bla.reader.defaultstrategies;

import java.io.*;

import bla.reader.base.Strategy;

/**
 * Task: read names from InputStream and show with hello
 */
public class GreetingStrategy implements Strategy {

    public void algorithm(InputStream inputStream) {
        String line;
        try {
            System.out.println("+++++++++++++++++GreetingStrategy++++++++++++++++++++++");
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((line = bufferReader.readLine()) != null) {
                System.out.println("Hello " + line);
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
