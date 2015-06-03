package se.addskills.day1.excercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingDemo {
	private IShoppingCart cart;
	private IAccount account;
	private List<Product> store;
	private Scanner in = new Scanner(System.in);

	/**
	 * On construction of demo inject the cart and account and populate the products with demo products.
	 * @param cart
	 * @param account
	 */
	public ShoppingDemo(IShoppingCart cart, IAccount account) {
		populateStore();
		this.cart = cart;
		this.account = account;
	}  // end constructor

	/**
	 * Create demo products.
	 */
	private void populateStore() {
		Product[] prods = {
				new Product ("Professional C# 4 and .NET 4", 354),
                new Product ("Beginning ASP.NET E-Commerce in C#", 260),
                new Product ("Objektorienterad analys och design", 418),
                new Product ("Improving Software Organizations", 486),
                new Product ("Operating System Concepts", 514),
                new Product ("Compilers: Principles, techniques and Tools", 1265),
                new Product ("Pro Git", 221),
                new Product ("Design Patterns", 315)
		};
		this.store = new ArrayList<>(Arrays.asList(prods));
	}  // end function populateStore

	/**
	 * Run the demo, read input number if not 6 then execute choice and exit when 6.
	 */
	public void run() {
		boolean running = true;
		
		while (running) {
			int input = printMenu();
			if (input == 6) {
				running = false;
			} else {
				makeChoice(input);
			}
		}
	}  // end function run

	/**
	 * switch over input number to invoke correct function.
	 * @param input
	 */
	private void makeChoice(int input) {
		switch (input) {
		case 1: {
				AddProductDialog();
				break;
			}
		case 2: {
				RemoveProductDialog();
				break;
			}
		case 3: {
				EmptyShoppingCart();
				break;
			}
		case 4: {
				ListProductsDialog();
				break;
			}
		case 5: {
				PaymentDialog();
				break;
			}
		}
	}

	/**
	 * Add product dialog, print all products and make user choose one.
	 */
	private void AddProductDialog() {
		System.out.println();
		System.out.println("Products in store");
		System.out.println("-----------------");
		System.out.println();
		int i = 1;
		for (Product product:store) {
			System.out.printf("%1$s) %2$s. Price: %3$s\n", i++, product.getName(), product.getPrice());
		}
		System.out.println();
		System.out.print("Enter product number: ");
		// Read chosen product
		int input = Integer.parseInt(in.next());

		// add chosen product to list of products
		if (input > store.size() || input <= 0) {
			System.out.println("Not a valid product number.");
		} else {
			cart.addProduct(store.get(input-1));
			account.remove(store.get(input-1).getPrice());
			System.out.printf("\"%s\" added to cart.\n", store.get(input-1));
		}
	}  // end function AddProductDialog

	/**
	 * Print products in list and get product to remove.
	 */
	private void RemoveProductDialog() {
		
		ListProductsDialog();
		
		System.out.println();
		System.out.print("Select an ITEM to REMOVE: ");
		
		int input =  in.nextInt();
		
		double price  = cart.removeProductByNumber(input-1).getPrice();
		account.add(price);
		System.out.println("Removed item from cart");
	}  // end function RemoveProductDialog

	/**
	 * Just remove all products in cart.
	 */
	private void EmptyShoppingCart() {
		cart.clear();
		System.out.println();
		System.out.println("--- Cleared shopping cart ---");
		System.out.println();
	}  // end function EmptyShoppingCart

	/**
	 * Process payment and remove money from account.
	 */
	private void PaymentDialog() {
		if (cart.isEmpty()) {
			System.out.println("--- Cart is empty ---");
			in.close();
			return;
		}
		
		double sum = cart.totalSum();
		
		if (sum > account.balance()) {
			System.out.println("Sorry, you do not have enough funds for purchase.");
		} else {
			System.out.print("Do you want to pay? [y/n]: ");
			String input = in.next();
			
			if (input.equalsIgnoreCase("n")) {
				in.close();
				return;
			}
			
			System.out.println("Thank you. Your order is being processed");
			account.remove(sum);
			cart.clear();
		}  // end balance ok
	}  // end function PaymentDialog

	/**
	 * Print products in cart to standard output.
	 */
	private void ListProductsDialog() {
		System.out.println("List all products in shopping cart");
		System.out.println("-------------------------");
		System.out.println();
		
		if (cart.isEmpty()) {
			System.out.println("--- Cart is empty ---");
		} 
		
		int i = 1;
		for (Product product:cart) {
			System.out.printf("%1$d) %2$s. Price: %3$s", i++, product.getName(), product.getPrice()); 
		}
		
		System.out.println();
	}  // end function ListProductsDialog


	/**
	 * Print choice menu to user and read int choice.
	 * @return
	 */
	private int printMenu() {
		
		System.out.println();
		System.out.println("Main Menu");
		System.out.println("---------");
		System.out.println("Your balance: " + account.balance());
		System.out.println("Total: " + cart.totalSum());
		System.out.println();
		System.out.println();
		System.out.println("1. Add product to shopping cart");
		System.out.println("2. Remove product from shopping cart");
		System.out.println("3. Empty shopping cart");
		System.out.println("4. List products in shopping cart");
		System.out.println("5. Pay");
		System.out.println("6. Exit");
		System.out.println("-------------------------------------");
		System.out.print("Choice > ");
		
		int choice = in.nextInt();
		return choice;
	}  // end function printMenu

}  // end class ShoppingDemo