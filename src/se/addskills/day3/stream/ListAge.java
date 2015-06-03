package se.addskills.day3.stream;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 1) Create Bean Person with attribute name and age.
 * 2) Create function that takes as input List<Person> and functional inteface Function<T,R> that gets the age of a person bean with method reference
 * 3) The function returns the list of ages
 * 4) Print ages with Consumer<T> interface
 */
public class ListAge {

    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Tim", 27));
        people.add(new Person("Sandra", 24));
        people.add(new Person("Elena", 41));

        List<Integer> ages = addAge(people, Person::getAge);
        ages.forEach(age->((Consumer<Integer>)System.out::println).accept(age));
    }  // end main

    /**
     * From Function interface put result from each Person on input list into new list and return.
     *
     * @param people List of Person beans
     * @param function Function that takes Person bean as input and returns Integer
     * @return List of ages for people on input
     */
    private static List<Integer> addAge(List<Person> people, Function<Person, Integer> function){
        List<Integer> ages = new ArrayList<>();

        people.forEach(person -> ages.add(function.apply(person)));

        return ages;
    }  // end function addAge

    private static class Person{
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