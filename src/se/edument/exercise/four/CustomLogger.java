package se.edument.exercise.four;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Exercise four
 *
 *
 *
 * 1) Create interface Logger with one function log that takes a String argument.
 * 2) Create a class CustomLogger that implements the Logger interface and has a Locale member with default Swedish locale.
 * 3) Create setter for locale
 * 4) Implement the log function formatting
 *
 *
 * Simple logger that will log to console information of a car.
 *
 * @author Tim Mickelson
 * @since 27/05/2015
 */
public class CustomLogger implements Logger{
    // Default to Sweden :)
    Locale locale = new Locale("sv", "SE");

    /**
     * Main class to run the example with various locales.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param args Command line arguments
     */
    public static void main(String[] args){
        // Create instance of custom logger
        CustomLogger logger = new CustomLogger();
        // Car attributes
        String brand = "Ferrari";
        Double price = 100356.05;
        Date purchase = new Date();
        // Log with Swedish locale
        logger.log(brand, price, purchase);
        // Log with English locale
        logger.setLocale(new Locale("en", "GB"));
        logger.log(brand, price, purchase);
        // Log with US local
        logger.setLocale(new Locale("en", "US"));
        logger.log(brand, price, purchase);
        // Log with Italian local
        logger.setLocale(new Locale("it", "IT"));
        logger.log(brand, price, purchase);
    }  // end main

    /**
     * Print to standard output a formated string that is formatted with Locale.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param brand
     * @param price
     * @param purchase
     */
    public void log(String brand, Double price, Date purchase){
        // MessageFormat pattern
        String pattern = "Brand: {0} price: {1, number, currency}, Purchased: {2, date, full}";
        // Create MessageFormat with class attribute locale
        MessageFormat msgFormatter = new MessageFormat(pattern, locale);
        Object[] params = {brand, price, purchase};
        // Format and print to standard output
        System.out.println( msgFormatter.format(params));
    }  // end function log

    @Override
    public void log(String message){
        System.out.println(message);
    }

    /**
     * Change Locale of CustomLogger instance.
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param locale
     */
    public void setLocale(Locale locale){
        this.locale = locale;
    }

}  // end class CustomLogger