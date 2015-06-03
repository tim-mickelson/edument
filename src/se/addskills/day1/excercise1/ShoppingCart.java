package se.addskills.day1.excercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classic Shopping cart with products.
 *
 * @author Tim Mickelson
 * @since 03/06/2015
 */
public class ShoppingCart implements IShoppingCart {
	private List<Product> products = new ArrayList<>();

	@Override
	public void addProduct(Product p) {
		this.products.add(p);
	}

	@Override
	public Product removeProductByNumber(int index) {
		return this.products.remove(index);
	}

	@Override
	public void clear() {
		this.products.clear();
	}

	/**
	 * Get sum of all products price.
	 * @return Total price of products
	 */
	@Override
	public double totalSum() {
		double sum = 0;
		for (Product product : products) {
			sum += product.getPrice();
		}
		return sum;
	}  // end function totalSum

	@Override
	public boolean isEmpty() {
		return this.products.isEmpty();
	}

	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}

}
