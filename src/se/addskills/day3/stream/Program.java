package se.addskills.day3.stream;

import se.addskills.day3.stream.ListAge.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 1) Create Bean Person with attribute name and age.
 * 2) Create function that takes as input List<Person> and functional inteface Function<T,R> that gets the age of a person bean with method reference
 * 3) The function returns the list of ages
 * 4) Print ages with Consumer<T> interface
 */
public class Program {

    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Tim", 57));
        people.add(new Person("Sandra", 24));
        people.add(new Person("Elena", 41));

        List<Integer> ages = ListAge.addAge(people, Person::getAge);

        ages.stream().filter(p->p.intValue()<42).forEach(age->((Consumer<Integer>)System.out::println).accept(age));

    }  // end main


}
