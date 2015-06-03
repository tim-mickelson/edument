package se.addskills.day3.excercise11;

public class ConsoleFactory {
	public static Console getInstance() {
		if (System.console() == null) {
			return new SystemOutConsole();
		}
		
		return new SystemConsole();
	}
}
