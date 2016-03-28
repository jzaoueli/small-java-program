package bla.test;

import bla.reader.Runner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static bla.reader.Runner.*;
import static org.junit.Assert.*;

/**
 * Created by EPD-Jihed on 26.03.2016.
 * Task: testing Runner.java
 */
public class RunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static final String EXPECTED_STRING_CALCULATE_FILE = "+++++++++++++++++CalculateStrategy++++++++++++++++++++++\r\n" +
            "the final sum = 45\r\n";
    private static final String EXPECTED_STRING_CALCULATE_STRING = "+++++++++++++++++CalculateStrategy++++++++++++++++++++++\r\n" +
            "the final sum = 2047\r\n";
    private static final String EXPECTED_STRING_GREETING_FILE = "+++++++++++++++++GreetingStrategy++++++++++++++++++++++\r\n" +
            "Hello Nico\r\n" +
            "Hello Enrico\r\n" +
            "Hello Alexander\r\n" +
            "Hello Michael\r\n" +
            "Hello Thomas\r\n" +
            "Hello Jana\r\n";
    private static final String EXPECTED_STRING_GREETING_STRING = "+++++++++++++++++GreetingStrategy++++++++++++++++++++++\r\n" +
            "Hello Enrico\r\n" +
            "Hello Alexander\r\n" +
            "Hello Thomas\r\n";
    private static final String EXPECTED_STRING_CUSTOM_STRATEGY_STRING = "Strategy not found, custom strategy will be used\r\n" +
            "+++++++++++++++++CustomStrategy++++++++++++++++++++++\r\n" +
            "congratulation Enrico\r\n" +
            "congratulation Alexander\r\n" +
            "congratulation Thomas\r\n";
    private static final String EXPECTED_STRING_CUSTOM_STRATEGY_FILE = "Strategy not found, custom strategy will be used\r\n" +
            "+++++++++++++++++CustomStrategy++++++++++++++++++++++\r\n" +
            "congratulation Nico\r\n" +
            "congratulation Enrico\r\n" +
            "congratulation Alexander\r\n" +
            "congratulation Michael\r\n" +
            "congratulation Thomas\r\n" +
            "congratulation Jana\r\n";

    private static final String CALCULATE_FILE_NAME_STRING = "files/calculate.txt";//
    private static final String GREETING_FILE_NAME_STRING = "files/greeting.txt";//

    private static final String CALCULATE_STRATEGY_STRING = "Calculate";//
    private static final String GREETING_STRATEGY_STRING = "Greeting";//
    private static final String CUSTOM_STRATEGY_STRING = "Praise";//

    private static final String CONTENT_CALCULATE_STRING = "24\n789\n1234";//
    private static final String CONTENT_GREETING_STRING = "Enrico\nAlexander\nThomas";//
    private static final String CONTENT_CUSTOM_STRING = "Enrico\nAlexander\nThomas";//


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testCalculateFile() {
        whenCalculateFile(CALCULATE_FILE_NAME_STRING);
        thenExpectedResultIsShown(EXPECTED_STRING_CALCULATE_FILE);
    }

    @Test
    public void testCalculateString() {
        whenCalculateString(CONTENT_CALCULATE_STRING, CALCULATE_STRATEGY_STRING);
        thenExpectedResultIsShown(EXPECTED_STRING_CALCULATE_STRING);
    }

    @Test
    public void testGreetingsFile() {
        whenGreetingsFile(GREETING_FILE_NAME_STRING);
        thenExpectedResultIsShown(EXPECTED_STRING_GREETING_FILE);
    }

    @Test
    public void testGreetingsString() {
        whenGreetingsString(CONTENT_GREETING_STRING, GREETING_STRATEGY_STRING);
        thenExpectedResultIsShown(EXPECTED_STRING_GREETING_STRING);
    }

    @Test
    public void testCustomStrategyString() {
        whenCustomStrategyString(CONTENT_CUSTOM_STRING, CUSTOM_STRATEGY_STRING);
        thenExpectedResultIsShown(EXPECTED_STRING_CUSTOM_STRATEGY_STRING);
    }

    @Test
    public void testCustomStrategyFile() {
        whenCustomStrategyFile(GREETING_FILE_NAME_STRING, CUSTOM_STRATEGY_STRING);
        thenExpectedResultIsShown(EXPECTED_STRING_CUSTOM_STRATEGY_FILE);
    }

    private void thenExpectedResultIsShown(String expectedString) {
        String outString = outContent.toString();
        assertEquals(expectedString, outString);
    }

    private static void whenCalculateFile(String fileName) {
        String strategy = Runner.getLineFromFile(fileName);
        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);
        startHandling(strategy, inputStream);
    }

    private static void whenCalculateString(String content, String CALCULATE_STRATEGY_STRING) {
        InputStream inputStream = getInputStreamFromString(content);
        startHandling(CALCULATE_STRATEGY_STRING, inputStream);
    }

    private static void whenGreetingsFile(String fileName) {
        String strategy = Runner.getLineFromFile(fileName);
        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);
        startHandling(strategy, inputStream);
    }

    private static void whenGreetingsString(String content, String strategy) {
        InputStream inputStream = getInputStreamFromString(content);
        startHandling(strategy, inputStream);
    }

    private static void whenCustomStrategyString(String content, String strategy) {
        InputStream inputStream = getInputStreamFromString(content);
        // use customStrategy (see member variable)
        startHandling(strategy, inputStream);
    }

    private static void whenCustomStrategyFile(String fileName, String strategy) {
        // use "files/greeting.txt"
        // use same strategy from testCustomStrategyString
        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);
        startHandling(strategy, inputStream);
    }

}