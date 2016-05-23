package se.addskills.day1.exercise2A;

public class Program {

	/**
	 * Simple test of CustomStack generic class. push some Integer objects and then print some pops
	 *
	 * 1. Create CustomStack that contains just a List<T>
	 * 2. Implement function to "push" an object
	 * 3. Implement function to "pop" an object (i.e. remove last object and return).
	 * 4. Implement function to "peek" an object (i.e. return reference of last object)
	 *
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

	}  // end function main

}  // end class Program