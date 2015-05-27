package se.edument.test.day3.thread;

/**
 * Created by Tim on 2015-05-24.
 */
public class TestLiveLock {

    public void testInterface(){
        //TestImpl impl = new TestImpl();
        //TestImpl.printme();
    }

    private class TestImpl implements ITest{

    }

    public interface ITest{
        public static void printme(){
            System.out.println("printme");
        }
    }


}  // end class TestLiveLock
