package bla.test2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import bla.test2.base.Strategy;

/**
 * Aufgabe: read names and show
 */
public class GreetingStrategy implements Strategy {


	public void algorithmus(String fileName){
		String line = "";
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferReader = new BufferedReader(inputStreamReader);		
			bufferReader.readLine();
			while((line=bufferReader.readLine())!= null){
				System.out.println("Hallo " + line);
			}
			bufferReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
