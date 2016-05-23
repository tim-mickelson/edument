package se.addskills.ex.day1.exercise1;

/**
 * Interface represents an shop Account.
 *
 */
public interface IAccount {

	double balance();

	void add(double amount);

	void remove(double amount);

}