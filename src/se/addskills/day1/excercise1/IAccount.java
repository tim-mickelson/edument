package se.addskills.day1.excercise1;

/**
 * Interface represents an shop Account.
 *
 * @author Tim Mickelson
 * @since 06/06/2015
 */
public interface IAccount {

	double balance();

	void add(double amount);

	void remove(double amount);

}  // end interface IAccount