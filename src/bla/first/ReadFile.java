package bla.first;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFile extends ClassB {
    public static void main(String[] args) {

        //while(true){
        try {
            //getting file_name from user
            //	String fileName = getFileName();

            //	mach(fileName);


        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");

        ClassA classA = new ClassA();
        ClassA classAbutIsB = new ClassB();
        ClassB classB = new ClassB();

        classA.doA();
        classA.doB();
        classA.doOnlyA();
        classA.blub(); // == ClassA.blub()

        classAbutIsB.doA();
        classAbutIsB.doB();
        classAbutIsB.doOnlyA();
        classAbutIsB.blub(); // == ClassA.blub()

        classB.doA();
        classB.doB();
        classB.doOnlyA();
        classB.blub(); // == ClassB.blub()
        ClassB.blub();

        //}
    }

    private static void mach(String fileName) throws Exception {


        //getting file_content from file
        BufferedReader bufferReader = getBuffer(fileName);

        //getting first line from file
        String firstLine;
        firstLine = bufferReader.readLine();

        //checking and processing file_content
        if (firstLine.equals("Greeting")) {
            greetAll(bufferReader);
        } else if (firstLine.equals("Calculate")) {
            calculateSumme(bufferReader);
        }

        bufferReader.close();

    }

    private static BufferedReader getBuffer(String fileName) {
        InputStream inputStream;
        BufferedReader bufferReader = null;
        try {
            inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferReader = new BufferedReader(inputStreamReader);
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return bufferReader;
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

    private static void greetAll(BufferedReader br) {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                showHallo(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void showHallo(String line) {
        System.out.println("Hallo " + line + ",");
    }

    private static void calculateSumme(BufferedReader br) {
        int summe = 0;
        String line = "";
        //int linePosition = 0;
        try {
            while ((line = br.readLine()) != null) {
                //linePosition++;
                //System.out.println("Zeile " + linePosition + " hat " + line + " --> Summe = " + summe + " + "  + line + " = " + (Integer.valueOf(line) + summe));
                summe = summe + Integer.valueOf(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("--> Final Summe = " + summe);
    }
}
