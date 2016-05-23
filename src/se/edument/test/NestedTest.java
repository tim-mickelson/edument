package se.edument.test;


/**
 * Created by purple.tim on 25/5/2015.
 */
public class NestedTest {
    String name = "unknown";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Nested{
        String surname = "unknown surname";

        @Override
        public String toString(){
            return "name = "+name+", surname = "+surname;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }


}
