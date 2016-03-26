package bla.reader.base;

import bla.reader.CalculateStrategy;
import bla.reader.GreetingStrategy;

import java.io.InputStream;

/**
 * decide if greeting or calculate
 * Aufgabe: call the strategy
 */
public class Context {

    private Strategy strategy;

    public Context(String strategyString) {
        if (strategy == null) {
            if (strategyString.equals("Calculate")) {
                strategy = new CalculateStrategy();
            } else if (strategyString.equals("Greeting")) {
                strategy = new GreetingStrategy();
            } else {
                System.out.println("will use custom strategy");
                //throw new RuntimeException(" the first line of file was : " + strategyString);
            }
        }

    }

    public void contextSchnittstelle(InputStream inputStream) {
        strategy.algorithmus(inputStream);
    }

    public void setStrategie(Strategy strategie) {
        this.strategy = strategie;
    }

}
