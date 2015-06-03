package se.addskills.day2.excercise5;

public enum WeightUnits {
	Pound (2.20462),
	Kilogram (1),
	Gram (1000),
	Tonne (0.001);
	
	private final double conversion;
	
	WeightUnits(double conversion) {
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