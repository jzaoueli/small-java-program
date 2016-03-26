package bla.test;

import bla.reader.Runner;
import bla.reader.base.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static bla.reader.Runner.customStrategy;
import static bla.reader.Runner.getInputStreamFromFileWithoutStrategy;
import static bla.reader.Runner.getInputStreamFromString;
import static org.junit.Assert.*;

/**
 * Created by EPD-Jihed on 26.03.2016.
 */
public class RunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private static final String EXPECTED_STRING_CALCULATE_FILE = "+++++++++++++++++CalculateStrategy++++++++++++++++++++++\r\n" +
            "the final sum =45";
    private static final String EXPECTED_STRING_CALCULATE_STRING = "+++++++++++++++++CalculateStrategy++++++++++++++++++++++\r\n" +
            "the final sum =2047";
    private static final String EXPECTED_STRING_GREETING_FILE = "+++++++++++++++++GreetingStrategy++++++++++++++++++++++\r\n" +
            "Hallo Nico\r\n" +
            "Hallo Enrico\r\n" +
            "Hallo Alexander\r\n" +
            "Hallo Michael\r\n" +
            "Hallo Thomas\r\n" +
            "Hallo Jana\r\n";
    private static final String EXPECTED_STRING_GREETING_STRING = "+++++++++++++++++GreetingStrategy++++++++++++++++++++++\r\n" +
            "Hallo Enrico\r\n" +
            "Hallo Alexander\r\n" +
            "Hallo Thomas\r\n";
    private static final String EXPECTED_STRING_CUSTOM_STRATEGY_STRING = "will use custom strategy\r\n" +
            "+++++++++++++++++CustomStrategy++++++++++++++++++++++\r\n" +
            "congratulation Enrico\r\n" +
            "congratulation Alexander\r\n" +
            "congratulation Thomas\r\n";
    private static final String EXPECTED_STRING_CUSTOM_STRATEGY_FILE = "will use custom strategy\r\n" +
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
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testCalculateFile() {
        whenCalculateFile();
        thenResultIsShown(EXPECTED_STRING_CALCULATE_FILE);
    }

    @Test
    public void testCalculateString() {
        whenCalculateString();
        thenResultIsShown(EXPECTED_STRING_CALCULATE_STRING);
    }

    @Test
    public void testGreetingsFile() {
        whenGreetingsFile();
        thenResultIsShown(EXPECTED_STRING_GREETING_FILE);
    }

    @Test
    public void testGreetingsString() {
        whenGreetingsString();
        thenResultIsShown(EXPECTED_STRING_GREETING_STRING);
    }

    @Test
    public void testCustomStrategyString() {
        whenCustomStrategyString();
        thenResultIsShown(EXPECTED_STRING_CUSTOM_STRATEGY_STRING);
    }

    @Test
    public void testCustomStrategyFile() {
        whenCustomStrategyFile();
        thenResultIsShown(EXPECTED_STRING_CUSTOM_STRATEGY_FILE);
    }

    private void thenResultIsShown(String expectedString) {
        String outString = outContent.toString();
        assertEquals(expectedString, outString);
    }

    private static void whenCalculateFile() {

        String strategyString = Runner.getLineFromFile(CALCULATE_FILE_NAME_STRING);

        InputStream inputStream = getInputStreamFromFileWithoutStrategy(CALCULATE_FILE_NAME_STRING);

        Context context = new Context(strategyString);
        context.contextSchnittstelle(inputStream);
    }

    private static void whenCalculateString() {
        InputStream inputStream = getInputStreamFromString(CONTENT_CALCULATE_STRING);

        Context context = new Context(CALCULATE_STRATEGY_STRING);
        context.contextSchnittstelle(inputStream);
    }

    private static void whenGreetingsFile() {
        String strategyString = Runner.getLineFromFile(GREETING_FILE_NAME_STRING);

        InputStream inputStream = getInputStreamFromFileWithoutStrategy(GREETING_FILE_NAME_STRING);

        Context context = new Context(strategyString);
        context.contextSchnittstelle(inputStream);
    }

    private static void whenGreetingsString() {
        InputStream inputStream = getInputStreamFromString(CONTENT_GREETING_STRING);

        Context context = new Context(GREETING_STRATEGY_STRING);
        context.contextSchnittstelle(inputStream);
    }

    private static void whenCustomStrategyString() {
        InputStream inputStream = getInputStreamFromString(CONTENT_CUSTOM_STRING);
        // use customStrategy (see member variable)

        Context context = new Context(CUSTOM_STRATEGY_STRING);
        context.setStrategie(customStrategy);
        context.contextSchnittstelle(inputStream);
    }

    private static void whenCustomStrategyFile() {
        // use "files/greeting.txt"
        // use same strategy from testCustomStrategyString

        InputStream inputStream = getInputStreamFromFileWithoutStrategy(GREETING_FILE_NAME_STRING);

        Context context = new Context(CUSTOM_STRATEGY_STRING);
        context.setStrategie(customStrategy);
        context.contextSchnittstelle(inputStream);
    }

}