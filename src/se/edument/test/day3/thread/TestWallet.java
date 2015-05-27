package se.edument.test.day3.thread;

/**
 * Created by Tim on 2015-05-24.
 */
public class TestWallet {


    public void testWallet(){
        Wallet wallet = new Wallet();
        wallet.add(500);

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });



    }


    private class Wallet{
        private int money;

        public void add(int money){
            this.money = money;
        }

        public int getMoney(){
            return money;
        }

    }

}  // end class TestWallet