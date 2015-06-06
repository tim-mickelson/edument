package se.addskills.day3.excercise10;

public class Program {
	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
		// Default values on class AClass are valid. Validate and prove on standard output.
		AClass c = new AClass();
		boolean result = Validator.validate(c);

		System.out.println("Is c valid ...? " + (result ? " yes!" : " no!"));

		// Put invalid value on theInt and show that it is not valid on standard output
		c.setTheInt(-1);
		result = Validator.validate(c);
		System.out.println("Is c valid ...? " + (result ? " yes!" : " no!"));
	}  // end function main

}
