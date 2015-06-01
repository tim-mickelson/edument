package se.addskills.day2.excercise5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

	public static void main(String[] args) {
		Weight weight = new Weight();
		
		weight.setWeight(WeightUnits.Gram, 550);
		weight.addWeight(WeightUnits.Pound, 5);
		weight.addWeight(WeightUnits.Kilogram, 5);
		
		System.out.println(weight.getWeight(WeightUnits.Kilogram));
		System.out.println(weight.getWeight(WeightUnits.Pound));
	}
}
