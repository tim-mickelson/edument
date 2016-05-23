package se.addskills.day1.exercise4A_tim;

import java.util.Date;
import java.util.Locale;

/**
 * Create class CustomLogger to log car information and that holds an instance of a Locale.
 */
public class Program {

    /**
     * Create interface to implement function> "void log(String message);"
     *
     * Main class to run the example with various locales.
     * Just simply print some information to standard output well formatted.
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

}  // end class Program