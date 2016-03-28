package bla.reader;

import java.io.*;
import java.nio.charset.StandardCharsets;

import bla.reader.base.Context;
import bla.reader.base.Strategy;

/**
 * Task:
 * - read file name
 * - get first line of file
 * - give file content to context
 */

public class Runner {

    /**
     * Task: read names from InputStream and show with congratulation
     */
    public static Strategy customStrategy = new Strategy() {

        @Override
        public void algorithm(InputStream inputStream) {
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
        while (true) {
            String userChoice = getChoiceOfUser();
            switch (userChoice) {
                case "file":
                    handleFile();
                    break;
                case "manually":
                    handleManual();
                    break;
                default:
                    throw new RuntimeException("User choice was : " + userChoice);
            }
        }
    }

    private static void handleManual() {
        String inputString = askUserAndGetAnswer("give your input :");
        String content = inputString.replaceAll("\\\\n", "\n");

        String userStrategy = askUserAndGetAnswer("Give the strategy to use : ");

        if (userStrategy.equals("Greeting") || userStrategy.equals("Calculate") || userStrategy.equals("Praise")) {
            InputStream inputStream = getInputStreamFromString(content);
            startHandling(userStrategy, inputStream);
        } else {
            throw new RuntimeException("Given Strategy don't exist : '" + userStrategy + "'");
        }
    }

    private static void handleFile() {
        String fileName = getFileNameFromUser();
        String userStrategy = getStrategy(fileName);
        InputStream inputStream = getInputStreamFromFileWithoutStrategy(fileName);
        startHandling(userStrategy, inputStream);
    }

    private static String getStrategy(String fileName) {
        String useCustomStrategy = askUserAndGetAnswer("If you want to use custom strategy give the name, else give 'no' :");
        String userStrategy;
        switch (useCustomStrategy) {
            case "no":
                userStrategy = getLineFromFile(fileName);
                break;
            case "Praise":
                userStrategy = useCustomStrategy;
                break;
            default:
                throw new RuntimeException("Given Strategy don't exist : '" + useCustomStrategy + "'");
        }
        return userStrategy;
    }

    public static void startHandling(String strategyString, InputStream inputStream) {
        Context context = new Context(strategyString);
        if (!strategyString.equals("Greeting") && !strategyString.equals("Calculate"))
            context.setStrategy(customStrategy);
        context.execute(inputStream);
    }


    public static String getLineFromFile(String fileName) {
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

    private static String getChoiceOfUser() {
        String fileName = "";
        try {
            InputStreamReader fileNameInputStreamReader = new InputStreamReader(System.in);
            BufferedReader keyboardInput = new BufferedReader(fileNameInputStreamReader);
            System.out.println("If you want to use textFile tape \"file\", ");
            System.out.print("if you want to give you text manually tape \"manually\" : ");
            fileName = keyboardInput.readLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return fileName;
    }

    private static String askUserAndGetAnswer(String question) {
        String inputText = "";
        try {
            InputStreamReader fileNameInputStreamReader = new InputStreamReader(System.in);
            BufferedReader keyboardInput = new BufferedReader(fileNameInputStreamReader);
            System.out.print(question);
            inputText = keyboardInput.readLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return inputText;
    }

    private static String getFileNameFromUser() {
        String fileName = "";
        try {
            InputStreamReader fileNameInputStreamReader = new InputStreamReader(System.in);
            BufferedReader keyboardInput = new BufferedReader(fileNameInputStreamReader);
            System.out.print("Give the path of file : ");
            fileName = keyboardInput.readLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return fileName;
    }

    public static InputStream getInputStreamFromFileWithoutStrategy(String fileName) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            bufferReader.readLine();
            String line;
            String stringResult = "";

            while ((line = bufferReader.readLine()) != null) {
                stringResult = stringResult + line + "\n";
            }
            inputStream = new ByteArrayInputStream(stringResult.getBytes(StandardCharsets.UTF_8));

            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream getInputStreamFromString(String contentString) {
        return new ByteArrayInputStream(contentString.getBytes(StandardCharsets.UTF_8));
    }
}
