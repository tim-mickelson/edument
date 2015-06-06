package se.addskills.day2.excercise8A;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.List;

/**
 *  Use books.xml file to load with SAX Parser and print nodes to standard output.
 *
 *  @author Tim Mickelson
 *  @since 06/06/2015
 */
public class Program {

    /**
     * Stream XML file and print to standard output using SAX.
     *
     * @author Tim Mickelson
     * @since 06/06/2015
     * @param args
     */
    public static void main(String[] args) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            PrintSAX printer = new PrintSAX();

            InputStream xmlFile = printer.load();
            parser.parse(xmlFile, printer);

            List<Book> books = printer.getBooks();
            for(Book book:books)
                System.out.printf("%s%n", book.toString());
        } catch (Exception e) {e.printStackTrace();}
    }  // end function main


}  // end class Program