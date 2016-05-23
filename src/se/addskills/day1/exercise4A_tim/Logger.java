package se.addskills.day1.exercise4A_tim;

import java.util.Date;
import java.util.Locale;

/**
 * Simple logger interface.
 *
 * @author Tim Mickelson
 */
public interface Logger {

    void log(String message);

    void setLocale(Locale locale);

    void log(String brand, Double price, Date purchase);

}