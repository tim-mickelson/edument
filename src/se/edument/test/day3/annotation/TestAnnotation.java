package se.edument.test.day3.annotation;

import org.junit.Test;

/**
 * Created by Tim on 2015-05-24.
 */
public class TestAnnotation {

    @Test
    public void testAnnotation(){
        Printer printer = new Printer();
        Object o;
        printer.print();
    } // end function testAnnotation

    private class Printer{

        @MultiCall(calls = 3)
        public void print(){
            System.out.println("Printing...");
        }

    }  // end class Printer

}  // end class TestAnnotation