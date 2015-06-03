package se.addskills.day1.excercise4A_tim;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Exercise four.
 *
 * The purpouse of this exercise is to get aquanted with formatting currency and dates switching the Locale between Swedish, Brittish and US.
 *
 * 1) Create a class CustomLogger that has an encapsulated Locale attribute.
 * 2) Create a setter for the Locale so it is possible to alter the Locale externally.
 * 3) Create the log function as so it takes the parameters, String brand, Double price, Date purchaseDate
 * 4) The implementation of the log function should use the Locale for formatting and including all parameters and put on standard output.
 * 5) Create main function and test the logger  with Locale for GB, US and SE
 */

/**
 *
 * Simple logger that will log to console information of a car.
 *
 * @author Tim Mickelson
 * @since 27/05/2015
 */
public class CustomLogger implements Logger {
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