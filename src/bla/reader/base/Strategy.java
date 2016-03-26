package bla.reader.base;

import java.io.InputStream;

/**
 * Task: Generalize strategy interface. InputStream handling
 */
public interface Strategy {

    void algorithm(InputStream inputStream);

}
