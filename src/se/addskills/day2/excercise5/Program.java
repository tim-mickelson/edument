package se.addskills.day2.excercise5;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

	/**
	 * Add weight in various units and print final solution to standard output.
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