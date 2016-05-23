package se.addskills.day3.excercis9;

public class Program {

	/**
	 * 1. Create wallet that holds money
	 * 		a) Create thread safe function to add money.
	 * 		b) Create thread safe function to extract money
	 * 2. Implement class Producer that implements Runnable and holds a reference to the Wallet
	 * 		a) Make it loop some 10 times adding random amount of money between 0 and 100
	 * 3. Implement class Consumer that implements Runnable and holds a reference to the Wallet
	 * 		a) Make it loop some 10 times extracting random amount of money from 0 and 100
	 * 		b) If it can not extract money, make it wait until there is money.
	 *
	 * Create a producer that will add money to the wallet and a consumer that will extract.
	 *
	 * Try removing the notify() in the add function, what will happen? Since the Consumer after extracting will wait() it will not
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