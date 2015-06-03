package se.addskills.day1.excercise2A;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack contains list of T with custom peek and pop function.
 * @param <T>
 */
public class CustomStack<T> {
	private List<T> stack;
	
	public CustomStack() {
		stack = new ArrayList<>();
	}
	
	public T peek() {
		int index = stack.size()-1;
		return stack.get(index);
	}

	/**
	 * Copy reference to last object in list then remove it from List. Now the List has no more reference to the object.
	 * @return
	 */
	public T pop() {
		T value = peek();
		stack.remove(value);
		return value;
	}
	
	public void push(T item) {
		stack.add(item);
	}

}  // end class CustomStack