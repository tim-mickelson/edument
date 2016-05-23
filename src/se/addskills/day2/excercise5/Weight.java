package se.addskills.day2.excercise5;

/**
 * Weight converter permitting to save weight units in lbl or kg and extract as lbl or kg.
 * The unit is defined together with the weight on input.
 *
 * @author Tim Mickelson
 * @since 06/06/2015
 */
public class Weight {
	private double weightInKG;

	/**
	 * Get weight in some given unit.
	 * @param unit Enumerator to precise the weight unit
	 * @return Weight
	 */
	public double getWeight(WeightUnits unit) {
		return this.weightInKG *  unit.value();
	}  // end function getWeight

	/**
	 * Set weight on Weight object.
	 * @param unit Enumerator to precise the weight unit
	 * @param weight weight in some unit
	 */
	public void setWeight(WeightUnits unit, double weight) {
		this.weightInKG = weight / unit.value();
	}  // end function setWeight

	/**
	 * Add weight in some unit.
	 * @param unit Enumerator to precise the weight unit
	 * @param weight weight in some unit
	 */
	public void addWeight(WeightUnits unit, double weight) {
		this.weightInKG += weight * unit.value();
	}  // end function addWeight

}  // end class Weight