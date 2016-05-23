package se.addskills.day1.exercise4B;

import java.util.Locale;

public class Program {

	/**
	 * 1. Create Car POJO with brand(String) and price (double)
	 * 2. Create TradeMessage POJO with car (Car), seller (String), buyer (String) and price (double) to use when logging a sale (i.e. implement function to sell as "public void sell(Car car, String seller, String buyer, double prize) ")
	 * 3. Create Logger interface with log function "log(TradeMessage msg)". Add function to add Locale.
	 * 4. Implement logger interface well formatted output. Try to use MessageFormat.format and passa variables as array of Object.
	 * 5. Create Stock to contain list of cars, on sell car do log (creating a TradeMessage and pass to custom logger). Inject Logger
	 *
	 * Create stock of cars and a Logger instance. Inject logger and car into Stock.
	 * For each sell do a Log.
	 */
	public static void main(String[] args) {
		Car volvo = new Car("Volvo", 19000.25);
		Car audi = new Car("Audi", 27456.12);
		Car trabant = new Car("Trabant", 800.50);
		Car moskowitz = new Car("Moskowitz", 799.99);
		
		Locale locale = new Locale("en", "GB");
		ILogger logger = new Logger(locale);
		
		Stock stock = new Stock(logger);
		stock.add(moskowitz);
		stock.add(trabant);
		stock.add(audi);
		stock.add(volvo);
		
		stock.sell(volvo, "Kalle", "Nisse", 18000);
		stock.sell(trabant, "Kalle", "Olle", 250.25);	
	}  // end function main

}  // end class Program