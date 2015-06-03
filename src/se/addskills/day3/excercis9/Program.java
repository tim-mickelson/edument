package se.addskills.day3.excercis9;

public class Program {

	/**
	 * Create a producer that will add money to the wallet and a consumer that will extract.
	 *
	 * Try removing the notify() in the add function, what will hapend? Since the Consumer after extracting will wait() it will not
	 * continue until the Producer has terminated it's thread that will send a notifyAll()
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Wallet wallet = new Wallet(1000);
		Thread producer = new Thread(new Producer(wallet), "Producer" );
		Thread consumer = new Thread(new Consumer(wallet), "Consumer");
		
		producer.start();
		consumer.start();
		System.out.println("main is finished but the threads just keep on going :-)");
	}  // end function main

}  // end class Program