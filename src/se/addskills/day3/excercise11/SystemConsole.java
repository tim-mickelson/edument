package se.addskills.day3.excercise11;

import java.io.Console;

public class SystemConsole implements se.addskills.day3.excercise11.Console {

	/**
	 * Constructor indicating that it has been called.
	 */
	public SystemConsole() {
		System.out.println("SystemConsole created");
	}

	/**
	 * Read line from standard input.
	 * @return Text line read from standard input
	 */
	@Override
	public String readLine() {
		Console console = System.console();
		return console.readLine();
	}  // end function readLine

	/**
	 * Write to standard output.
	 * @param str
	 */
	@Override
	public void write(String str) {
		Console console = System.console();
		console.printf(str);
	}  // end function write

}  // end class SystemConsole