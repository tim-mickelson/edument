package se.addskills.day2.excercise5;

public class Weight {
	private double weightInKG;
	
	public double getWeight(WeightUnits unit) {
		return this.weightInKG * WeightUnits.valueOf(unit);
	}
	
	public void setWeight(WeightUnits unit, double weight) {
		this.weightInKG = weight / WeightUnits.valueOf(unit); 
	}
	
	public void addWeight(WeightUnits unit, double weight) {
		this.weightInKG += weight * WeightUnits.valueOf(unit);
	}
}
