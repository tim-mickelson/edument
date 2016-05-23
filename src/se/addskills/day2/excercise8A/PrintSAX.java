package se.addskills.day2.excercise8A;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * SAX parser for simple book XML. Print nodes to standard output and parse nodes into book beans.
 *
 * @author Tim Mickelson
 * @since 01/06/2015
 */
public class PrintSAX extends DefaultHandler {
	// Bean for+65241 current Book bean

	private Book book = null;
	// BookType enumerator for current tag type
	private BookType type = BookType.unknown;
	// List of accumelated books
	private List<Book> books = new ArrayList<>();

	// Enumerator to keep track of current XML tag
	private enum BookType{
		unknown("unknown"), title("title"), author("author"), genre("genre"), price("price"), publishDate("publish_date"), description("description");

		private String value;

		private BookType(String value){
			this.value = value;
		}

		public static BookType bookType(String value){
			for(BookType type:BookType.values()){
				if(type.value.equals(value))
					return type;
			}

			return unknown;
		}
	}  // end enum BookType

	public List<Book> getBooks(){
		return books;
	}

	/**
	 * Get InputStream for books.xml file from classpath.
	 * @return
	 */
	public InputStream load(){
		InputStream xmlFile = getClass().getClassLoader().getResourceAsStream("books.xml");
		return xmlFile;
	}

	@Override
	public void startDocument() {
		System.out.println("Catalog: ");
		
	}

	@Override
	public void endDocument() {
		System.out.println("----------------------------------------------");
		System.out.println("End catalog.");
	}

	/**
	 * Start element set current node type to catch up when parsing text node
	 * @param uri
	 * @param lName
	 * @param qName
	 * @param attrs
	 */
	@Override
	public void startElement(String uri, String lName, String qName, Attributes attrs) {
		// With this one row we can avoid the whole switch statement below
		type = BookType.bookType(qName);

		switch (qName) {
			case "book": {
				book = new Book();
				String value = attrs.getValue("id");
				book.setId(value);
				System.out.println("----------------------------------------------");
				System.out.println("Book id: " + value);
				break;
			}
			case "author": {
				System.out.print("Author: ");
				break;
			}
			case "title": {
				System.out.print("Title: ");
				break;
			}
			case "genre": {
				System.out.print("Genre: ");
				break;
			}
			case "price": {
				System.out.print("Price: ");
				break;
			}
			case "publish_date": {
				System.out.print("Published: ");
				break;
			}
			case "description": {
				System.out.print("Description: ");
				break;
			}
			default:
				type = BookType.unknown;
		}
	}

	@Override
	public void endElement (String uri, String localName, String qName) throws SAXException{
		type = BookType.unknown;
		if(qName.equals("book")){
			books.add(book);
			book = null;
		}
	}  // end function endElement

	@Override
    public void characters(char ch[], int start, int length) {
    	String text = (new String(ch,start,length)).trim();
		switch (type){
			case title: book.setTitle(text);
				break;
			case author: book.setAuthor(text);
				break;
			case genre: book.setGenre(text);
				break;
			case price: book.setPrice(text);
				break;
			case publishDate: book.setPublishDate(text);
				break;
			case description: book.setDescription(text);
				break;
			default:
		} // end switch

    	if (text.length()>0) System.out.println(text);
    }  // end charachters
	
}  // end class PrintSAX
