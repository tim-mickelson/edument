package se.addskills.day1.excercise4B;

/**
 * Car POJO
 */
public class Car {
	private final String carBrand;
	private double prize;

	public Car(String brand, double prize) {
		this.carBrand = brand;
		this.prize = prize;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}
}
