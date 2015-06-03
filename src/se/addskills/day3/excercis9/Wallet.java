package se.addskills.day3.excercis9;

public class Wallet {
	private long amount;

	/**
	 * Simple constructor forcing some money in new Wallet.
	 * @param amount
	 */
	public Wallet(int amount) {
		this.amount = amount;
	}

	/**
	 * Add money to wallet thread safe. What happends if we remove the notify()? Then the Consumer, if waiting will wait until the
	 * Producer thread terminates, so first all money will be added in loop, else each add will notify the Consumer that it can remove
	 * money.
	 *
	 *
	 * @param amount
	 */
	public synchronized void add(int amount) {
		this.amount += amount;
		System.out.printf("%1$s: Added %2$s. %3$s in wallet.\n", Thread.currentThread().getName(), amount, this.amount);
		notify();
	}  // end function add

	/**
	 * Remove money from the wallet if there is money enough. The function is Thread safe.
	 *
	 * @param amount
	 * @return true if removed
	 */
	public synchronized boolean remove(int amount) {
		if (this.amount >= amount) {
			this.amount -= amount;
			System.out.printf("%1$s: Removed %2$s. %3$s remaining.\n", Thread.currentThread().getName(), amount, this.amount);
			return true;
		}
		return false;
	}  // end function remove

}  // end class Wallet