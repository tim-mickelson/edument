package se.addskills.day3.excercise10;

/**
 * Simple class to test @Validate annotation. Instantiated with valid values, possible to change with setters.
 *
 * @author Tim Mickelson
 * @since 03/06/2015
 */
public class AClass {
	@Validate({Predicates.NOTNULL, Predicates.NOTEMPTY})
	private String theString = "Hello World!";
	@Validate(Predicates.NOTNEGATIVE)
	private int theInt = 17;

	public void setTheString(String theString) {
		this.theString = theString;
	}

	public void setTheInt(int theInt) {
		this.theInt = theInt;
	}
} // end class AClass