package se.edument.test.day1.recap;

import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.function.Consumer;

/**
 * Simple JUnit String manipulation tests.
 *
 * Created by Tim on 2015-05-23.
 */
public class TestString {

    @Test
    public void testLambda(){
        Integer i = 8;


        Lambda lambda = new Lambda();
        Consumer<Void> consumerOne = (p)->{
            lambda.pippo(i);
        };

        Consumer<Void> consumerTwo = (p)->{
            lambda.pero(i);
        };

        // The functional reference must be assigned to a corresponding Functional interface type. E.g. nada takes
        // Integer on input and returrns nothing, Consumer<T> is a good functional interface.
        Consumer<Integer> consumerThree = lambda::nada;

        consumer(consumerOne);
        consumer(consumerTwo);
        consumer2(consumerThree);
    }

    private void consumer(Consumer<Void> consumer){
        consumer.accept(null);
    }

    private void consumer2(Consumer<Integer> consumer){
        consumer.accept(null);
    }

    /**
     * Just do simple String format tests.
     */
    @Test
    public void testFormats(){
        String stringFormat = String.format("String: \"%10S\"%n", "Hello");
        String stringFormat2 = String.format("String: \"%10S\"%n", "forza juventus");
        String floatFormat = String.format("Float (sc): %.5e%n", 123456789.123);


        System.out.println(stringFormat);
        System.out.println(stringFormat2);
        System.out.println(floatFormat);
    } // end function testFormats

    /**
     * Test of StringBuilder vs String. StringBuilder basically holds an array of char and on <i>toString</i> the String is created.
     */
    @Test
    public void testStringBuilder(){
/*
        Good for small operations bad for loops and other since String is immutable. This means using tons of memory on the Heap
        Solution: StringBuilder ;)
        String a = "a";
        a += "b";
*/
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");

        System.out.println(sb.toString());

    }  // end function testStringBuilder

    /**
     * Simple JUnit tests on date formatting.
     */
    @Test
    public void testDateFormat(){
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(dateTime.toString());
        String today = String.format("%1$-15s: %2$td %2$tB %2$tY", "LocalDateTime", dateTime);
        System.out.println(today);

        Date date = new Date();
        System.out.println(date.toString());
        today = String.format("%1$-15s: %2$td %2$tB %2$tY", "Date", date);
        System.out.println(today);

        // Tomorrow
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        today = String.format("%1$-15s: %2$td %2$tB %2$tY", "Tomorrow", date);
        System.out.println(today);
    }  // end function testDateFormat


    /**
     * Read Comma Seperated Value file and print information split by ',' in standard output.
     */
    @Test
    public void testReadFile() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("csv.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if(fields!=null){
                String name = fields.length>0?fields[0]:"undefined";
                String year = fields.length>1?fields[1]:"undefined";
                String description = fields.length>2?fields[2]:"undefined";
                String formatted = String.format("name: %1$s, year: %2$s, description: %3$s", name, year, description);

                System.out.println(formatted);
            } // end fields not null

        }
        reader.close();

    } // end function testReadFile

    /**
     * Simple JUnit Locale tests
     */
    @Test
    public void testFormat(){
        // Language, Country, Variant
        Locale localeGb = new Locale("en", "GB", "WIN");
        Locale localeSw = new Locale("sv", "SE");

        NumberFormat nf = NumberFormat.getNumberInstance(localeGb);
        Integer quantity = 123456;
        Double amount = 3456.789;

        String stringQuantity = nf.format(quantity);
        String stringAmount = nf.format(amount);

        System.out.println(stringQuantity+" "+localeGb.toString());
        System.out.println(stringAmount+" "+localeGb.toString());

        nf = NumberFormat.getNumberInstance(localeSw);
        stringQuantity = nf.format(quantity);
        stringAmount = nf.format(amount);
        System.out.println(stringQuantity+" "+localeSw.toString());
        System.out.println(stringAmount + " " + localeSw.toString());

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println(dateFormat.format(LocalDateTime.now()));

        // Java < 8
        DateFormat dateForm = DateFormat.getDateInstance(DateFormat.LONG, localeSw);
        Date date = new Date();
        String stringDate = dateForm.format(date);
        System.out.println(stringDate);

        String pattern = "{0, date, full} test {1} Time {2, time, full}";
        MessageFormat msgFormatter = new MessageFormat(pattern, localeGb);
        Object[] data = {new Date(), "West", new Date()};
        String s = msgFormatter.format(data).toString();
        System.out.println(msgFormatter.format(data));

    }  // end function testLocale


}  // end class TestString