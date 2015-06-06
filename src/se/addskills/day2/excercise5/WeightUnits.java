package se.addskills.day2.excercise5;

/**
 * Enumerator for weight units with converter constants.
 *
 * @author Tim Mickelson
 * @since 06/06/2015
 */
public enum WeightUnits {
	Pound (2.20462),
	Kilogram (1),
	Gram (1000);
	
	private final double conversion;
	
	private WeightUnits(double conversion) {
		this.conversion = conversion;
	}  // end constructor

	/**
	 * Utility function to extract weight conversation factor from given WeightUnits unit.
	 * @param unit WeightUnits enumerator value
	 * @return conversation factor
	 */
	static double valueOf(WeightUnits unit) {
		return unit.conversion;
	}  // end function valueOf

}  // end enumerator WeightUnits