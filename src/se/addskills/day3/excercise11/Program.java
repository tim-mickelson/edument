package se.addskills.day3.excercise11;

public class Program {

	public static void main(String[] args) {
		Console console = ConsoleFactory.getInstance();
		
		console.write("What is your name? ");
		String input = console.readLine();
		console.write("Hello " + input + "!\n");
		console.write("Where do you live? ");
		input = console.readLine();
		console.write("I love " + input + "!!!");
	}

}
