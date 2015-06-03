package se.addskills.day3.excercis9;

import java.util.Random;

/**
 * Thread that will extract money in a loop and after each extraction wait() until notified.
 *
 * @author Tim Mickelson
 * @since 03/06/2015
 */
public class Consumer implements Runnable {
	private Wallet wallet;

	/**
	 * Simple constructor setting the wallet.
	 * @param wallet
	 */
	public Consumer(Wallet wallet) {
		this.wallet = wallet;
	}

	/**
	 * Loop removing money in each cycle and then wait for notify.
	 *
	 * @author Tim Mickelson
	 * @since 03/06/2015
	 */
	@Override
	public void run() {
		int times = 10;
		Random rand = new Random();
		for (int i=0;i<times;i++) {
			int amount = rand.nextInt(100);
			try {
				// If remove was ok, then wait till Producer thread adds new money or Producer thread terminates
				if (!wallet.remove(amount))
					wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}  // end loop times
	}  // end function run

}  // end class Consumer