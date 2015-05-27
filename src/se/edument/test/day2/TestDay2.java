package se.edument.test.day2;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tim on 2015-05-23.
 */
public class TestDay2 {


    public void testAddCar() throws ParserConfigurationException, IOException, SAXException, URISyntaxException, TransformerException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("car-stock.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        String targa = "ghi 789";
        String brand = "Ferrari";
        String condition = "Super";
        String price = "1000000";
        String currency = "USD";

        Element carElement = document.createElement("car");
        Node stock = document.getDocumentElement();
        carElement.setAttribute("id", targa);
        stock.appendChild(carElement);


        Element brandElement = document.createElement("brand");
        brandElement.setTextContent(brand);
        carElement.appendChild(brandElement);

        Element conditionElement = document.createElement("condition");
        conditionElement.setTextContent(condition);
        carElement.appendChild(conditionElement);

        Element priceElement = document.createElement("price");
        priceElement.setTextContent(price);
        priceElement.setAttribute("currency", currency);
        carElement.appendChild(priceElement);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        URL url = getClass().getClassLoader().getResource("car-stock.xml");
        System.out.printf("url: %s", url.toString());
        File file = new File(url.toURI());
        OutputStream output = new FileOutputStream(file);
        Result result = new StreamResult(output);
        DOMSource source = new DOMSource(document);

        transformer.transform(source, result);
    }  // end function testAddCar

    @Test
    public void testSaxXml() throws ParserConfigurationException, SAXException, IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("car-stock.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SaxHandler handler = new SaxHandler();
        parser.parse(is, handler);

    } // end function testSaxXml

    public void testDomXml() throws ParserConfigurationException, IOException, SAXException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("car-stock.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        NodeList nodeList = document.getElementsByTagName("car");

        for(int i=0;i<nodeList.getLength();i++){
            Node car = nodeList.item(i);
            Node brand = car.getFirstChild();

            boolean found = false;
            while(!found){
                if(brand.getNodeType()==Node.TEXT_NODE) {
                    found = brand.getNodeValue().trim().length()==0;
                    brand = brand.getNextSibling();
                }
            }

            System.out.printf("Brand: %s", brand.getTextContent());
        } // end loop nodeList
    }  // end function testDomXml

    public void testRegExp(){
        String patternString = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(patternString);
        String[] emails = {"valid@valid.se", "invalid@invalid", "valid+butFails@domain.se", "valid-good.good@valid.se"};

        for(String email:emails){
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches())
                System.out.println(email+" valid");
            else
                System.out.println(email+" INVALID");
        }

    }  // end function testRegExp

    public void testEnum(){
        if(true)
            try {
                throw new HttpException(HttpError.BAD_REQUEST, "Page not found");
            } catch (HttpException e) {
                switch (e.error()){
                    case ACCEPTED:
                        System.out.println(String.format("Accepted request: %s", e.error().toString()));
                        break;
                    case BAD_REQUEST:
                        System.out.println(String.format("Bad request: %s", e.error().toString()));
                        break;
                    default:
                        System.out.println(e.error().toString());
                }  // end switch
            }  // end catch

    }  // end function testEnum

    private class SaxHandler extends DefaultHandler{

        @Override
        public void startElement(String uri, String lname, String qname, Attributes attributes) throws SAXException{
            switch (qname){
                case "car": System.out.println("Car: "+attributes.getValue("id"));
                    break;
                case "brand": System.out.print("Brand: ");
                    break;
                case "condition": System.out.print("Condition: ");
                    break;
                case "price": System.out.print("Price: ");
                    break;
                default:{}
            }  // end switch
        }  // end function startElement

        @Override
        public void characters(char ch[], int start, int length) throws SAXException{
            String out = new String(ch, start, length).trim();
            if(out.length()>0)
                System.out.println(out);
        } // end function characters

        @Override
        public void startDocument()throws SAXException{
            System.out.println("Start document");
        }

        @Override
        public void endDocument()throws SAXException{
            System.out.println("End document");
        }

    }  // end class SaxHandler

    private class HttpException extends Exception{
        private HttpError error;

        public HttpException(HttpError error, String message){
            super(message);
            this.error = error;
        }  // end constructor

        public HttpError error(){
            return error;
        }

    }  // end class HttpException

    /**
     * Enumerator for common HTTP codes.
     *
     * @author Tim Mickelson
     * @since 26/05/2015
     */
    private enum HttpError{
        OK(200), ACCEPTED(202), BAD_REQUEST(400), FORBIDDEN(403), NOT_FOUND(404);
        private int value;

        /**
         * Private constructor injecting the value
         * @param value
         */
        private HttpError(int value){
            this.value = value;
        }  // end constructor

        /**
         * Nice String with name and code of enumerator.
         * @return Returns the name and code of this enum constant, as contained in the declaration.
         */
        @Override
        public String toString(){
            return super.toString()+" ("+value+")";
        }

        public int value(){
            return value;
        }

        /**
         * Utility function to map int code to corresponding Social enumerator.
         *
         * @param value code of Social enumerator
         * @throws IllegalArgumentException if value not valid
         * @return The mapped Social entity
         */
        public static HttpError httpError(int value){
            for(HttpError error:HttpError.values()){
                if(error.equals(value))
                    return error;
            }
            // If we come here the int value is not valid
            throw new IllegalArgumentException("value = "+value+" is not a valid enumerator code!");
        }  // end public static function social

    }  // end enumerator Social

}  // end class TestDay2