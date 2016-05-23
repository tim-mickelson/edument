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
	 * Get conversion factor.
	 * @return Conversion factor value
	 */
	public double value(){
		return conversion;
	}

}  // end enumerator WeightUnits