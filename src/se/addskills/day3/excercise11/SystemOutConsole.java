package se.addskills.day3.excercise11;

import java.util.Scanner;

public class SystemOutConsole implements Console {
	private final Scanner scanner;
	
	public SystemOutConsole() {
		System.out.println("SystemOutConsole created");
		scanner = new Scanner(System.in);
	}
	
	@Override
	public String readLine() {
		return scanner.nextLine();
	}

	@Override
	public void write(String str) {
		System.out.print(str);
	}

}
