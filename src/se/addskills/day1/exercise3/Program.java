package se.addskills.day1.exercise3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read CSV file, split and inject into LanguageData beans and then print to standard output.
 */
public class Program {

	/**
	 * Read in  file and print out well formatted the lines.
	 */
	public static void main(String[] args) {
		List<LanguageData> languageData = new ArrayList<>();
		Scanner in = new Scanner(System.in);

		try {
			languageData = ListLoader.LoadListFromFile("LanguageData.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Enter name of programming language (case independent)");
		String lang = in.next();
		int found = 0;
		for(LanguageData ld:languageData){
			if(ld.getName().toLowerCase().equals(lang.toLowerCase())){
				found++;
				System.out.printf("Name: %1$s%nDate: %2$s%nDescription: %3$s%n%n",
						ld.getName(), ld.getReleaseYear(), ld.getDescription());
			}
		}

	}  // end function main

}  // end class Program