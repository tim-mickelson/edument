package se.addskills.day2.excercise8B;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

/**
 * 1. Load XML books.xml file into DOM Document.
 * 2. Navigate in tree and print nodes to standard output.
 * 3. Add new book to XML and save to file
 *
 * @author Tim Mickelson
 * @since 06/06/2015
 */
public class Program {

    /**
     * Read books xml file into BookReader, print to standard output and then save a new book to file.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param args
     */
    public static void main(String[] args){
        BookReader bookReader = new BookReader("books.xml");
        try {
            bookReader.loadXml();

            bookReader.addBook("BK666", "Tim Mickelson", "Java Intermidiet", "Programming", 6010.25, LocalDate.now(), "Good book");

            List<Node> bookList = bookReader.findBook("BK666");
            for(Node book:bookList){
                bookReader.printBook(book);
            }

            bookReader.save();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    } // end function main


}  // end class Program