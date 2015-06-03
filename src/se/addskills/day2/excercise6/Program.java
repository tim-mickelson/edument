package se.addskills.day2.excercise6;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Program {

	/**
	 * Read inputs and try with regexps.
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws ParserConfigurationException {
		Scanner in = new Scanner(System.in);
		String input = "";
		Sale sale = new Sale();
		do {
			System.out.print("Enter name of Seller: ");
			input = in.nextLine();
		} while (!sale.validate(Patterns.NAMEPATTERN, input));
		sale.setSeller(input);
		
		do {
			System.out.print("Enter name of Buyer: ");
			input = in.nextLine();
		} while (!sale.validate(Patterns.NAMEPATTERN, input));
		sale.setBuyer(input);
		
		do {
			System.out.print("Enter buyer SSN: ");
			input = in.nextLine();
		} while (!sale.validate(Patterns.SSNPATTERN, input));
		sale.setSSN(input);
		
		do {
			System.out.print("Enter car Registration: ");
			input = in.nextLine();
		} while (!sale.validate(Patterns.REGPATTERN, input));
		sale.setReg(input);
		
		do {
			System.out.print("Enter sale price: ");
			input = in.nextLine();
		} while (!sale.validate(Patterns.PRICEPATTERN, input));
		sale.setPrice(input);
		
		System.out.println();
		System.out.println(sale.toString());
		in.close();
		
//		Path path = Paths.get("f:\\staff.xml");
//		InputStream is = Files.newInputStream(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//		Document doc = dBuilder.parse(is);
		
		Document doc = dBuilder.newDocument();
		Element root = doc.createElement("Company");
		doc.appendChild(root);
		
		Element staff = doc.createElement("Staff");
		root.appendChild(staff);
		
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		staff.setAttributeNode(attr);
	}  // end function main

}  // end class Program