package se.addskills.day1.excercise4B;

import java.util.Locale;

public class Program {

	/**
	 * Create stock of cars and a Logger instance. Inject logger and car into Stock.
	 * For each sell do a Log.
	 */
	public static void main(String[] args) {
		Car volvo = new Car("Volvo", 19000.25);
		Car audi = new Car("Audi", 27456.12);
		Car trabant = new Car("Trabant", 800.50);
		Car moskowitz = new Car("Moskowitz", 799.99);
		
		Locale locale = new Locale("en", "GB");
		ILogger log = new Logger(locale);
		
		Stock stock = new Stock(log);
		stock.add(moskowitz);
		stock.add(trabant);
		stock.add(audi);
		stock.add(volvo);
		
		stock.sell(volvo, "Kalle", "Nisse", 18000);
		stock.sell(trabant, "Kalle", "Olle", 250.25);	
	}  // end function main

}  // end class Program