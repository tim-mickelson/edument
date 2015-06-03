package se.addskills.day1.excercise1;

import java.util.Iterator;

public interface IShoppingCart extends Iterable<Product>{
	void addProduct(Product p);
	Product removeProductByNumber(int index);
	void clear();
	double totalSum();
	boolean isEmpty();
	Iterator<Product> iterator();
}
