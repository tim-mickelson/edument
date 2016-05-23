package se.addskills.day1.exercise1;

/**
 * 1. Create POJO for products (name, price)
 * 2. Implement IAccount to hold balance and add/remove
 * 3. Implement IShoppingCart. Implementation should encapsulate List<Product> and implement interface functions
 * 4. Create demo that can add products (could be simple setter/getter for Product or full-blown like this demo).
 * 5. Print products to standard output.
 *
 * IAccount
 * IShoppingCart
 *
 * @author Tim Mickelson
 * @since 06/06/2015
 */
public class Program {

	public static void main(String[] args) {
		// Simple container for money
		IAccount account = new Account();
		IShoppingCart cart = new ShoppingCart();
		// Inject cart and account to ShoppingDemo instance
		ShoppingDemo demo = new ShoppingDemo(cart, account);

		// start account with 1500
		account.add(1500);
		// run the demo
		demo.run();
	}  // end function main

}  // end class Program