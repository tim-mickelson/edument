package se.addskills.day1.excercise4B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Stock of cars in List.
 */
public class Stock implements Iterable<Car> {
	private List<Car> stock;
	private ILogger logger;

	/**
	 * Inject logger in constructor. Implementation elsewhere.
	 */
	public Stock(ILogger logger) {
		this.stock = new ArrayList<>();
		this.logger = logger;
	}  // end constructor

	@Override
	public Iterator<Car> iterator() {
		return stock.iterator();
	}
	
	public void add(Car car) {
		stock.add(car);
	}

	/**
	 * Sell car make a log.
	 */
	public void sell(Car car, String seller, String buyer, double prize) {
		this.stock.remove(car);
		TradeMessage message = new TradeMessage(car, seller, buyer, prize);
		logger.Log(message);
	}  // end function sell

}  // end class Stock