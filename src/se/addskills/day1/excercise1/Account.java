package se.addskills.day1.excercise1;

/**
 * Simple POJO with account balance.
 * @author Tim Mickelson
 * @since 03/06/2015
 */
public class Account implements IAccount {
	private double balance = 0;

	@Override
	public double balance() {
		return this.balance;
	}

	@Override
	public void add(double amount) {
		this.balance += amount;
	}

	@Override
	public void remove(double amount) {
		this.balance -= amount;
	}

}  // end class Account