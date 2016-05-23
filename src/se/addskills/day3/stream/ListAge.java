package se.addskills.day3.stream;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ListAge {

    /**
     * From Function interface put result from each Person on input list into new list and return.
     *
     * @param people List of Person beans
     * @param function Function that takes Person bean as input and returns Integer
     * @return List of ages for people on input
     */
    public static List<Integer> addAge(List<Person> people, Function<Person, Integer> function){
        List<Integer> ages = new ArrayList<>();

        people.forEach(person -> ages.add(function.apply(person)));

        return ages;
    }  // end function addAge

    public static class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }  // end class Person
}  // end class ListAge