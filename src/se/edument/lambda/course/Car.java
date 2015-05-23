package se.edument.lambda.course;

public class Car {
	private String model;
	private Brand brand;
	private double price;
	
	/**
	 * Car constructor with initial parameters.
	 * @param model Free text field for model description
	 * @param brand Car brand enumerator
	 * @param price Car price
	 */
	public Car(String model, Brand brand, double price){
		this.model = model;
		this.brand = brand;
		this.price = price;
	}  // end constructor
	
	public void printCar(){
		String car = String.format("Brand: %1$s\nModel: %2$s\nPrice: %3$s\n",  brand, model, price);
		System.out.println(car);
	}  // end function printCar

	@Override
	public String toString() {
		return "Car [model=" + model + ", brand=" + brand + ", price=" + price
				+ "]";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}  // end class Car