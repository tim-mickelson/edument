package se.addskills.day3.excercis9;

import java.util.Random;

/**
 * Thread that will add random amount of money in a loop and then terminate.
 *
 * @author Tim Mickelson
 * @since 03/06/2015
 */
public class Producer implements Runnable {
	private Wallet wallet;

	/**
	 * Simple constructor setting the wallet.
	 * @param wallet
	 */
	public Producer(Wallet wallet) {
		this.wallet = wallet;
	}

	/**
	 * Execute loop inserting money on each cycle.
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
			wallet.add(amount);
		}
	}  // end function run

}  // end class Producer