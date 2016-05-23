package se.addskills.day1.exercise1;

/**
 * Simple POJO for generic Product
 */
public class Product {
	private double price;
	private String name;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}
}  // end class Product