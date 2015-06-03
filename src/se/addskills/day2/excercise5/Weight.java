package se.addskills.day2.excercise5;

public class Weight {
	private double weightInKG;

	/**
	 * Get weight in some given unit.
	 * @param unit Enumerator to precise the weight unit
	 * @return Weight
	 */
	public double getWeight(WeightUnits unit) {
		return this.weightInKG * WeightUnits.valueOf(unit);
	}  // end function getWeight

	/**
	 * Set weight on Weight object.
	 * @param unit Enumerator to precise the weight unit
	 * @param weight weight in some unit
	 */
	public void setWeight(WeightUnits unit, double weight) {
		this.weightInKG = weight / WeightUnits.valueOf(unit); 
	}  // end function setWeight

	/**
	 * Add weight in some unit.
	 * @param unit Enumerator to precise the weight unit
	 * @param weight weight in some unit
	 */
	public void addWeight(WeightUnits unit, double weight) {
		this.weightInKG += weight * WeightUnits.valueOf(unit);
	}  // end function addWeight

}  // end class Weight