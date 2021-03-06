package bla.reader.base;

import bla.reader.defaultstrategies.CalculateStrategy;
import bla.reader.defaultstrategies.GreetingStrategy;

import java.io.InputStream;

/**
 * Task:
 * - decide if greeting, calculate or custom
 * - call the strategy
 * this class can do much more than it do
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
                System.out.println("Strategy not found, custom strategy will be used");
                //throw new RuntimeException(" the first line of file was : " + strategyString);
            }
        }
    }

    public void execute(InputStream inputStream) {
        strategy.algorithm(inputStream);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}
