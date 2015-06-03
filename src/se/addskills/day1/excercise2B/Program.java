package se.addskills.day1.excercise2B;

public class Program {

	public static void main(String[] args) {
		CustomQueue<Integer> myQueue = new CustomQueue<>();

        myQueue.enqueueBack(5);
        myQueue.enqueueBack(10);
        myQueue.enqueueBack(15);
        
        System.out.println(myQueue.dequeueFront());
	}

}
