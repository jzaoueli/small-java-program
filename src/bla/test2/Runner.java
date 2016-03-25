package bla.test2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
        public void algorithmus(String fileName) {
            // print with appended "ist Toll"
            // print count of names
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

//		Context context = new Context();
//		//Strategie strategie = new KonkreteStrategieA();
//		Strategy strategie = new GreetingStrategy();
//		
//		context.setStrategie(strategie);
//		context.contextSchnittstelle();
    }

    public static void testCalculateFile() {
        String fileName = "files/calculate.txt";//

        String firstLine = getLineFromFile(fileName);
        context = new Context(firstLine);
        context.contextSchnittstelle(fileName);
    }

    public static void testCalculateString() {
        String strategyString = "Calculate";//
        String content = "24\n789\n1234";//

        context = new Context(strategyString);
        context.contextSchnittstelle(content);
    }

    public static void testGreetingsFile() {
        String fileName = "files/greeting.txt";//

        String firstLine = getLineFromFile(fileName);
        context = new Context(firstLine);
        context.contextSchnittstelle(fileName);
    }

    public static void testGreetingsString() {
        String strategyString = "Greeting";//
        String content = "Enrico\nAlexander\nThomas";//

        context = new Context(strategyString);
        context.contextSchnittstelle(content);
    }

    public static void testCustomStrategyString() {
        String strategyString = "Praise";//
        String content = "Enrico\nAlexander\nThomas";//

        // use customStrategy (see member variable)
        context = new Context(strategyString);
        context.contextSchnittstelle(content);
    }

    public static void testCustomStrategyFile() {
        // use "files/greeting.txt"
        // use same strategy from testCustomStrategyString
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

    private static String getFileName() {
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
}
