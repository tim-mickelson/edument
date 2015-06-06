package se.addskills.day1.excercise2B;

/**
 * 1. Implement class that simulates Queue of objects T (actually contains a List<T>)
 * 2. Implement check function if queue is empty, then throw IllegalAccessError
 * 3. Implement "front" function to get first element in queue (check validity)
 * 4. Implement "back" function to get last element in queue (check validity)
 * 5. Implement "dequeueFront" function to get first element in list and remove it (...)
 * 6. Implement "dequeueBack" function to get last element in list and remove it (...)
 * 7. Implement "enqueueFront" to add an object as first in list
 * 8. Implement "enqueueBack" to add object last in list
 */
public class Program {

        public static void main(String[] args) {
                CustomQueue<Integer> myQueue = new CustomQueue<>();

                myQueue.enqueueBack(5);
                myQueue.enqueueBack(10);
                myQueue.enqueueBack(15);

                System.out.println(myQueue.dequeueFront());
	    }  // end main function

}  // end class Program