package se.addskills.day1.excercise2B;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Queue class not implementing the Queue interface
 * @param <T>
 */
public class CustomQueue<T> {
	private List<T> queue = new ArrayList<>();

	/**
	 * If queue is empty throw Exception
	 * @throws IllegalAccessError
	 */
	private void checkValidity() {
		if (queue.isEmpty()) {
			throw new IllegalAccessError("Queue is empty");
		}
	}  // end function checkValidity

	/**
	 * Get first element in queue
	 * @return Element of zero index
	 * @throws IllegalAccessError if queue is not valid
	 */
	public T front() {
		checkValidity();
		return queue.get(0);
	}  // end front

	/**
	 * Get last element in queue
	 * @return Element in queue with max index of queue size
	 * @throws IllegalAccessError if queue is not valid
	 */
	public T back() {
		checkValidity();
		return queue.get(queue.size()-1);
	}  // end function back

	/**
	 * Get first element in queue and delete from list.
	 * @return First element in queue
	 * @throws IllegalAccessError if queue is not valid
	 */
	public T dequeueFront() {
		T value = front();
		queue.remove(0);
		return value;
	}  // end function dequeueFront

	/**
	 * Get last element in queue and remove from list.
	 * @return Last element in queue
	 * @throws IllegalAccessError if queue is not valid
	 */
	public T dequeueBack() {
		T value = back();
		queue.remove(queue.size()-1);
		return value;
	}  // end function dequeueBack
	
	public void enqueueFront(T item) {
		queue.add(0, item);
	}
	
	public void enqueueBack(T item) {
		queue.add(item);
	}
}  // end class CustomQueue