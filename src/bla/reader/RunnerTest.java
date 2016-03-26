package bla.reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by EPD-Jihed on 26.03.2016.
 */
public class RunnerTest {

    /*
    // Greeting
    testCalculateFile();
    testCalculateString();

    // Calculate
    testGreetingsFile();
    testGreetingsString();

    // Praise
    testCustomStrategyString();
    testCustomStrategyFile();
    */

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


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
    public void testCalculateFiles() {
        String expectedString = "+++++++++++++++++CalculateStrategy++++++++++++++++++++++\r\n" +
                "the final sum =45";

        Runner.testCalculateFile();

        String outString = outContent.toString();

        assertEquals(expectedString, outString);
    }

    @Test
    public void testCalculateString() {
        String expectedString = "+++++++++++++++++CalculateStrategy++++++++++++++++++++++\r\n" +
                "the final sum =2047";

        Runner.testCalculateString();

        String outString = outContent.toString();

        assertEquals(expectedString, outString);
    }

    @Test
    public void testGreetingsFile() {
        String expectedString = "+++++++++++++++++GreetingStrategy++++++++++++++++++++++\r\n" +
                "Hallo Nico\r\n" +
                "Hallo Enrico\r\n" +
                "Hallo Alexander\r\n" +
                "Hallo Michael\r\n" +
                "Hallo Thomas\r\n" +
                "Hallo Jana\r\n";

        Runner.testGreetingsFile();

        String outString = outContent.toString();

        assertEquals(expectedString,outString);
    }

}