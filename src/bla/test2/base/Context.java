package bla.test2.base;

import bla.test2.CalculateStrategy;
import bla.test2.GreetingStrategy;

/**
 * decide if greeting or calculate
 * Aufgabe: call the strategy
 */
public class Context {

    private Strategy strategy;

    public Context(String strategyString) {
        if (strategyString.equals("Calculate")) {
            strategy = new CalculateStrategy();
        } else if (strategyString.equals("Greeting")) {
            strategy = new GreetingStrategy();
        } else {
            throw new RuntimeException(" the first line of file was : " + strategyString);
        }
    }

    public void contextSchnittstelle(String fileName) {
        strategy.algorithmus(fileName);
    }

    public void setStrategie(Strategy strategie) {
        this.strategy = strategie;
    }

}
