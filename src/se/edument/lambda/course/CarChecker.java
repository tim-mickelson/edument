package se.edument.lambda.course;

public class CarChecker implements ICheckCar {

	@Override
	public boolean check(Car car, double minPrice, double maxPrice, String model) {
		if(car.getPrice()<=maxPrice && car.getPrice()>=minPrice){
			// if model input is null and car model not or vice versa then false (to avoid null pointer in next check)
			if((car.getModel()!=null&&model==null)||(car.getModel()==null&&model!=null)){
				return false;
			}
			if((car.getModel()==null&&model==null)||(car.getModel().equals(model))){
				return true;
			}
		} // end car with price within limit
		return false;
	}  // end function check

}  // end class CarChecker