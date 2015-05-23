package se.edument.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

import org.junit.Test;

import se.edument.lambda.course.Brand;
import se.edument.lambda.course.Car;
import se.edument.lambda.course.CarChecker;
import se.edument.lambda.course.CarStock;
import se.edument.lambda.course.ICheckCar;

public class TestLambda {
	
	@Test
	public void testCar(){
		Car saab = new Car("9000", Brand.saab, 100.3);
		Car volvo = new Car("242", Brand.volvo, 508.23);
		Car nullVolvo = new Car("x", Brand.volvo, 1000.23);
	
		CarStock carStock = new CarStock();
		carStock.add(saab);
		carStock.add(volvo);
		carStock.add(nullVolvo);
		
		// print only by price range
		carStock.printCarsWithinPriceRange(101.0, 600);
		// print by price range and model
		carStock.printCarsWithinPriceRangeAndModel(1000, 6000, null);
		
		// Interface 
		ICheckCar carChecker = new CarChecker();
		carStock.printCars(carChecker, 400, 6000, "242");

		// Anonymous class
		carStock.printCars(new ICheckCar() {
			@Override
			public boolean check(Car car, double minPrice, double maxPrice, String model) {
				// OBS: No null checks :)
				return car.getPrice()<=maxPrice&&car.getPrice()>=minPrice&&car.getModel().equals(model);
			}
		}, 400, 500, "242");
		
		System.out.println("+------------------ Lambda ----------------+");
		carStock.printCars((car,min,max,model)->car.getPrice()>=min&&car.getPrice()<=max&&car.getModel().equals(model), 
				400.1, 6000.2, "242");
		
	}
}  // end class TestLambda