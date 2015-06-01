package se.addskills.day2.excercise8B;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Exercise eight
 *
 * Read xml file into DOM Document and print and manipulate the books in xml file.
 *
 * 1) Create BookReader class with Document attribute.
 * 2) Read file into DOM Document
 * 3) Implement function to print all books to standard output.
 * 4) Implement function to add new book to DOM Document.
 * 5) Write DOM Document to file.
 *
 * extra) Implement Logger interface for logging that logs to XML file
 */

/**
 * Exercise eleven
 *
 * Create filter function for book attribute id and print found books to standard output.
 *
 * 1) Create public function to get List<Node> of book Node's
 * 2) Create private function to loop over books and test predicate to filter out book nodes
 *
 */

/**
 * Read xml file from classpath into BookReader dom document attribute. Print books and create function to save new book to file.
 *
 * @author Tim Mickelson
 * @since 27/05/2015
 */
public class BookReader {
    private Document document = null;
    private String fileName;

    public BookReader(String fileName){
        this.fileName = fileName;
    }
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
//            bookReader.printBooks();

            bookReader.addBook("BK666", "Tim Mickelson", "Java Intermidiet", "Programming", 6010.25, LocalDate.now(), "Good book");
            // Print with new node
//            bookReader.printBooks();

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

    /**
     * Get all <i>book</i> elements in XML and print the child nodes with text content.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     */
    public void printBooks(){
        NodeList nodeList = document.getElementsByTagName("book");

        for(int i=0;i<nodeList.getLength();i++){
            Node book = nodeList.item(i);
            printBook(book);
        } // end loop nodelist

    }  // end function printCars

    /**
     * Find book with given id attribute using Predicate inteface.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param id Book id attribute
     */
    private List<Node> findBook(String id){
        List<Node> books = filterBooks(b->{
            NamedNodeMap attributes = b.getAttributes();
            return (attributes!=null&&attributes.getLength()>0&&attributes.item(0).getTextContent().equals(id));
        });

        return books;
    }  // end function findBook

    /**
     * Filter books with predicate. This function gets the list of book nodes and confronts them with the external conditions
     * implemented in the predicate inteface implementation.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param predicate Test interface
     * @return List of book Node's that correspond to predicate condition.
     */
    private List<Node> filterBooks(Predicate<Node> predicate){
        NodeList nodeList = document.getElementsByTagName("book");
        List<Node> books = new ArrayList<>();

        for(int i=0;i<nodeList.getLength();i++){
            Node book = nodeList.item(i);
            if(predicate.test(book))
                books.add(book);
        } // end loop nodelist

        return books;
    }  // end function filterBooks


    /**
     * Print all child nodes to book Node to standard output with tag name and text content.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param book Book node
     */
    private void printBook(Node book){
        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
        NamedNodeMap attrs = book.getAttributes();
        if(attrs!=null&&attrs.getLength()>0){
            System.out.println(String.format("%s: %s", attrs.item(0).getNodeName(), attrs.item(0).getTextContent()));
        }
        for(int i=0;i<book.getChildNodes().getLength();i++){
            Node node = book.getChildNodes().item(i);
            // TODO PRINT BOOK ID
            if(node.getNodeType()!=Node.TEXT_NODE){
                if(node.getNodeName()!=null)
                System.out.println(String.format("%s: %s", node.getNodeName(), node.getTextContent()));
            }
        }
    } // end function printBook

    /**
     * Load XML books file into Document attribute.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public void loadXml() throws ParserConfigurationException, IOException, SAXException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        document = builder.parse(is);
    }  // end function loadXml

    /**
     * Add new book Element to DOM Document.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     */
    public void addBook(String bookId, String author, String title, String genre, Double price, LocalDate publishDate, String description){
        Element book = document.createElement("book");
        Node root = document.getDocumentElement();
        book.setAttribute("id", bookId);
        root.appendChild(book);

        Element authorElement = document.createElement("author");
        authorElement.setTextContent(Objects.toString(author, ""));
        book.appendChild(authorElement);

        Element titleElement = document.createElement("title");
        titleElement.setTextContent(Objects.toString(title, ""));
        book.appendChild(titleElement);

        Element genreElement = document.createElement("genre");
        genreElement.setTextContent(Objects.toString(genre, ""));
        book.appendChild(genreElement);

        Element priceElement = document.createElement("price");
        priceElement.setTextContent(Objects.toString(price, ""));
        book.appendChild(priceElement);

        Element publishDateElement = document.createElement("publish_date");
        String publish = publishDate==null?"":publishDate.toString();
        publishDateElement.setTextContent(publish);
        book.appendChild(publishDateElement);

        Element descriptionElement = document.createElement("description");
        descriptionElement.setTextContent(Objects.toString(description, ""));
        book.appendChild(descriptionElement);

    } // end function addBook

    /**
     * Save DOM Document to text file.
     * @throws TransformerException
     * @throws URISyntaxException
     * @throws FileNotFoundException
     */
    public void save() throws TransformerException, URISyntaxException, FileNotFoundException {
        URL url = getClass().getClassLoader().getResource(fileName);
        System.out.println(url.toURI().toString());
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        File file = new File(url.toURI() );
        OutputStream os = new FileOutputStream(file);
        Result result = new StreamResult(os);
        DOMSource source = new DOMSource(document);

        transformer.transform(source, result);
    }  // end function save

}
