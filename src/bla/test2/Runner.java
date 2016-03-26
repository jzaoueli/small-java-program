package bla.test2;

import java.io.*;
import java.nio.charset.StandardCharsets;

import bla.test2.base.Context;
import bla.test2.base.Strategy;

/**
 * read file name
 * get first line of file
 * give file content to context
 */

public class Runner {

    private static Context context;

    private static Strategy customStrategy = new Strategy() {

        @Override
        public void algorithmus(InputStream inputStream) {
            String line;
            try {
                System.out.println("+++++++++++++++++CustomStrategy++++++++++++++++++++++");
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while ((line = bufferReader.readLine()) != null) {
                    System.out.println("congratulation " + line);
                }
                bufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {

        // Greeting
        // Calculate
        // Praise

        testCalculateFile();
        testCalculateString();

        testGreetingsFile();
        testGreetingsString();

        testCustomStrategyString();
        testCustomStrategyFile();

//		Context context = new Context();
//		//Strategie strategie = new KonkreteStrategieA();
//		Strategy strategie = new GreetingStrategy();
//		
//		context.setStrategie(strategie);
//		context.contextSchnittstelle();
    }

    public static void testCalculateFile() {
        String fileName = "files/calculate.txt";//

        String strategyString = getLineFromFile(fileName);

        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);

        context = new Context(strategyString);
        context.contextSchnittstelle(inputStream);
    }

    public static void testCalculateString() {
        String strategyString = "Calculate";//
        String content = "24\n789\n1234";//

        InputStream inputStream = getInputStreamFromString(content);

        context = new Context(strategyString);
        context.contextSchnittstelle(inputStream);
    }

    public static void testGreetingsFile() {
        String fileName = "files/greeting.txt";//

        String strategyString = getLineFromFile(fileName);

        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);

        context = new Context(strategyString);
        context.contextSchnittstelle(inputStream);
    }

    public static void testGreetingsString() {
        String strategyString = "Greeting";//
        String content = "Enrico\nAlexander\nThomas";//

        InputStream inputStream = getInputStreamFromString(content);

        context = new Context(strategyString);
        context.contextSchnittstelle(inputStream);
    }

    public static void testCustomStrategyString() {
        String strategyString = "Praise";//
        String content = "Enrico\nAlexander\nThomas";//

        InputStream inputStream = getInputStreamFromString(content);
        // use customStrategy (see member variable)

        context = new Context(strategyString);
        context.setStrategie(customStrategy);
        context.contextSchnittstelle(inputStream);
    }

    public static void testCustomStrategyFile() {
        // use "files/greeting.txt"
        // use same strategy from testCustomStrategyString

        String fileName = "files/greeting.txt";//
        String strategyString = "Praise";//

        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);

        context = new Context(strategyString);
        context.setStrategie(customStrategy);
        context.contextSchnittstelle(inputStream);
    }

    private static String getLineFromFile(String fileName) {
        String line = "";
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);

            line = bufferReader.readLine();
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    private static String getFileNameFromUser() {
        String fileName = "";
        try {
            InputStreamReader fileNameInputStreamReader = new InputStreamReader(System.in);
            BufferedReader keyboardInput = new BufferedReader(fileNameInputStreamReader);
            System.out.print("Path von Text Datei eingeben : ");
            fileName = keyboardInput.readLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return fileName;
    }

    private static InputStream getInputStreamFromFileWithoutStrategy(String fileName) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            bufferReader.readLine();
            String line = "";
            String stringResult = "";

            while ((line = bufferReader.readLine()) != null) {
                stringResult = stringResult + line + "\n";
            }
            InputStream inputStreamResult = new ByteArrayInputStream(stringResult.getBytes(StandardCharsets.UTF_8));

            return inputStreamResult;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static InputStream getInputStreamFromString(String contentString) {
        InputStream contentInputStream = new ByteArrayInputStream(contentString.getBytes(StandardCharsets.UTF_8));
        return contentInputStream;
    }
}
