package se.addskills.day1.excercise1;

/**
 * Implement interface
 *
 * IAccount
 * IShoppingCart
 */
public class Program {
	public static void main(String[] args) {
		// Simple container for money
		Account account = new Account();
		IShoppingCart cart = new ShoppingCart();
		// Inject cart and account to ShoppingDemo instance
		ShoppingDemo demo = new ShoppingDemo(cart, account);

		// start account with 1500
		account.add(1500);
		// run the demo
		demo.run();
	}  // end function main

}  // end class Program