package se.addskills.day1.excercise1;

import java.util.Iterator;

/**
 * Interface representing a shopping cart.
 *
 * @author Tim Mickelson
 * @since 06/06/2015
 */
public interface IShoppingCart extends Iterable<Product>{

	void addProduct(Product p);

	Product removeProductByNumber(int index);

	void clear();

	double totalSum();

	boolean isEmpty();

	Iterator<Product> iterator();

}  // end interface