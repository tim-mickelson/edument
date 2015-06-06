package se.addskills.day1.excercise3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read CSV file, split and inject into LanguageData beans and then print to standard output.
 */
public class Program {

	/**
	 * Read in  file and print out well formatted the lines.
	 */
	public static void main(String[] args) {
		List<LanguageData> languageData = new ArrayList<>();
		try {
			languageData = ListLoader.LoadListFromFile("H:\\LanguageData.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (LanguageData ld:languageData) {
			System.out.printf("Name: %1$s\nDate: %2$s\nDescription: %3$s\n\n",
					ld.getName(), ld.getReleaseYear(), ld.getDescription());
			
		}
	}  // end function main

}  // end class Program