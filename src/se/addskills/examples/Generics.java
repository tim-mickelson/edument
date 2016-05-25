package se.addskills.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Some code example to highlight difference between Java Generics and not.
 */
public class Generics {

    public static void main(String[] args){
        String string = "String Object";
        Integer integer = Integer.valueOf(6);

        // Before JDK1.5
        List rawType = new ArrayList();
        // All objects added are of type Object (no compile-time check)
        rawType.add(string);
        rawType.add(integer);

        // If we get an object we do not know what type it is so we must
        for(int i=0;i<rawType.size();i++){
            Object object = rawType.get(i);
            // 1. Check type
            if(object instanceof String){
                System.out.println("This is a String with the value: "+(String)object);
            } else if(object instanceof Integer){
                System.out.println("This is a Integer with the value: "+(Integer)object);
            }
            // 2. Assume to know type and cast runtime. If the Object is not String we will get an error, but only at runtime
            //System.out.println("Type is always  an String with value: "+(String)object);
        }

        // With Generics (and diamond operator)
        List<String> stringList = new ArrayList<>();
        stringList.add(string);
        // Not possible to add Integer object, will have error already at compile time
        //stringList.add(integer);

        // We can loop over String directly since the type is well known and this is possible since JDK1.5 together with Generics
        for(String str : stringList){
            System.out.println("String value is : "+str);
        }

    }

}
