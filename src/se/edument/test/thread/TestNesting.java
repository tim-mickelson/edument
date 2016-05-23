package se.edument.test.thread;

import org.junit.Test;
import se.edument.test.NestedTest;

/**
 * Created by purple.tim on 25/5/2015.
 */
public class TestNesting {

    @Test
    public void testNest() {

        NestedTest nestedTest = new NestedTest();
        NestedTest.Nested nested = nestedTest.new Nested();
        System.out.println(nested.toString());
    }

     //(nested.toString());
}
