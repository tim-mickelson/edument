package se.edument.exercise.eight;

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
import java.util.Date;
import java.util.Objects;

/**
 * Created by purple.tim on 27/5/2015.
 */
public class BookReader {
    private Document document = null;


    public static void main(String[] args){
        BookReader bookReader = new BookReader();
        try {
            bookReader.loadXml();
            bookReader.printBooks();

            bookReader.addBook("BK666", "Tim Mickelson", "Java Intermidiet", "Programming", 6010.25, LocalDate.now(), "Good book");
            // Print with new node
            bookReader.printBooks();

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

        //for(Node node:nodeList){}
        for(int i=0;i<nodeList.getLength();i++){
            Node book = nodeList.item(i);
            printBook(book);
        } // end loop nodelist

    }  // end function printCars

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
        InputStream is = getClass().getClassLoader().getResourceAsStream("books.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        document = builder.parse(is);
    }  // end function loadXml

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

    public void save() throws TransformerException, URISyntaxException, FileNotFoundException {
        URL url = getClass().getClassLoader().getResource("books.xml");
        System.out.println(url.toURI().toString());
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        File file = new File(url.toURI() );
        OutputStream os = new FileOutputStream(file);
        Result result = new StreamResult(os);
        DOMSource source = new DOMSource(document);

        transformer.transform(source, result);
    }  // end function save

}
