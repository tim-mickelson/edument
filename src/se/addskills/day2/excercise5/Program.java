package se.addskills.day2.excercise5;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

	/**
	 * Add weight in various units and print final solution to standard output.
	 * units should be kg and lbs, but could also be e.g. gram
	 *
	 * Use equation kg = (1/2.20462)*x lbs
	 *              lbs= 2.20462*x kg
	 *
	 * 1. Create enumerator for weight types with weight factor
	 * 2. Create a class that internally holds weight as kg shows why encapsulation is fundamental :)
	 * 3. Add weight of unit defined by enum in input.
	 * 4. Print weight in all units
	 */
	public static void main(String[] args) {
		Weight weight = new Weight();

		weight.setWeight(WeightUnits.Gram, 550);
		weight.addWeight(WeightUnits.Pound, 5);
		weight.addWeight(WeightUnits.Kilogram, 5);
		
		System.out.println(String.format(new Locale("sv", "SE"), "%.2f kg", weight.getWeight(WeightUnits.Kilogram)));
		System.out.println(String.format(new Locale("en", "GB"),"%.2f pound", weight.getWeight(WeightUnits.Pound)));
	}  // end function main

}  // end class Program