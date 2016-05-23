package se.addskills.ex.day1.exercise1;

import se.addskills.day1.exercise1.Product;

import java.util.Iterator;

/**
 * Interface representing a shopping cart.
 *
 */
public interface IShoppingCart extends Iterable<Product>{

	void addProduct(Product p);

	Product removeProductByNumber(int index);

	void clear();

	double totalSum();

	boolean isEmpty();

	Iterator<Product> iterator();

}