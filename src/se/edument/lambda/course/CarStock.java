package se.edument.lambda.course;

import java.util.ArrayList;
import java.util.List;

public class CarStock {
	private List<Car> cars = new ArrayList<>();
	
	public void add(Car car){
		cars.add(car);
	}
	
	/**
	 * Print to standard output cars that have a price within given price range.
	 * 
	 * @author Tim Mickelson
	 * @since 22/05/2015
	 * @param minPrice Lower price level of interest
	 * @param maxPrice Higher price level of interest
	 */
	public void printCarsWithinPriceRange(double minPrice, double maxPrice){
		// loop cars no null pointer check, cars is instantiated on object creation.
		for(Car car:cars){
			if(car.getPrice()<=maxPrice && car.getPrice()>=minPrice){
				car.printCar();
			} // end car with price within limit
		} // end loop cars
		
	}  // end function printCarsWithinPriceRange
	
	
	/**
	 * Print to standard output cars that have a price within given price range.
	 * 
	 * @author Tim Mickelson
	 * @since 22/05/2015
	 * @param minPrice Lower price level of interest
	 * @param maxPrice Higher price level of interest
	 * @param model Car model name
	 */
	public void printCarsWithinPriceRangeAndModel(double minPrice, double maxPrice, String model){
		// loop cars no null pointer check, cars is instantiated on object creation.
		for(Car car:cars){
			if(car.getPrice()<=maxPrice && car.getPrice()>=minPrice){
				// if model input is null and car model not or vice versa then break
				if((car.getModel()!=null&&model==null)||(car.getModel()==null&&model!=null)){
					break;
				}
				if((car.getModel()==null&&model==null)||(car.getModel().equals(model))){
					car.printCar();
				}
			} // end car with price within limit
		} // end loop cars
		
	}  // end function printCarsWithinPriceRange

	public void printCars(ICheckCar checkCar, double minPrice, double maxPrice, String model){
		for(Car car:cars){
			if(checkCar.check(car, minPrice, maxPrice, model)){
				car.printCar();
			}  // end checkCar
		} // end loop cars
	}  // end function printCars
	
}  // end class CarStock