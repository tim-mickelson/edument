package se.addskills.ex.day1.exercise1;

/**
 * Created by purple.tim on 23/5/2016.
 */
public class Program {

    public static void main(String[] args){
        IAccount account = null;
        IShoppingCart cart = null;

        // Inject cart and account to ShoppingDemo instance
        ShoppingDemo demo = new ShoppingDemo(cart, account);

        // start account with 1500
        account.add(1500);
        // run the demo
        demo.run();
    }
}
