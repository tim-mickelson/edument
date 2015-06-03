package se.addskills.day1.excercise2A;

public class Program {

	/**
	 * Simple test of CustomStack generic class. push some Integer objects and then print some pops
	 * @param args
	 */
	public static void main(String[] args) {
		CustomStack<Integer> stack = new CustomStack<>();
		
		stack.push(5);
		stack.push(10);
		stack.push(15);
		stack.push(20);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}  // end function main

}  // end class Program