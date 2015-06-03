package se.edument.test.day3.reflection;

import org.junit.Test;
import se.edument.test.day3.annotation.MultiCall;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Tim on 2015-05-24.
 */
public class TestReflection {

    @Test
    public void testBeanReflection(){
        Contact contact = new Contact("Tim", "Mickelson");

        execute(contact);
    }  // end function testReflection

    private void execute(Object object){

        try {
            Class<?> objectClass = Class.forName(object.getClass().getName());
            Method[] methods = objectClass.getDeclaredMethods();

            for(Method method:methods){
                System.out.println(method.getName());
                if(method.getName().equals("setFullName")){
                    Object[] parameters = {"firstName", "lastName"};
                    method.invoke(object, parameters);
                   // ((Contact) object).toString();
                }
                MultiCall call = method.getAnnotation(MultiCall.class);
                if(call!=null){
                    for (int i=0;i<call.calls();i++){
                        method.invoke(object, null);
                    }
                }
            } // end loop methods

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }  // end function execute

    private class Contact{
        private String name;
        private String surname;

        public Contact(String name, String surname){
            this.name = name;
            this.surname = surname;
        }

        @MultiCall(calls = 3)
        @Override
        public String toString(){
            String tostring = "Contact [name="+name+", surname="+surname+"]";
            System.out.println("Contact::toString - "+tostring);
            return tostring;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setFullName(String name, String surname){
            this.name = name;
            this.surname = surname;
        }
    }  // end class Contact

}  // end class TestReflection