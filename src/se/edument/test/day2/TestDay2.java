package se.edument.test.day2;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tim on 2015-05-23.
 */
public class TestDay2 {

    @Test
    public void testRegExp(){
        Pattern pattern = Pattern.compile("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$");
        String[] emails = {"valid@valid.se", "invalid@invalid", "valid+butFails@domain.se"};

        for(String email:emails){
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches())
                System.out.println(email+" valid");
            else
                System.out.println(email+" INVALID");
        }

    }  // end function testRegExp

    @Test
    public void testBoxing(){
        long start = System.currentTimeMillis();

        for(int i=0;i<1000000000;i++) {
            int j = i;
        }
        long stop = System.currentTimeMillis();
        start = (stop-start);
        System.out.println("time = "+start);

        start = System.currentTimeMillis();
        for(int i=0;i<1000000000;i++){
            Integer j = i;
        }
        stop = System.currentTimeMillis();
        start = (stop-start);
        System.out.println("time = "+start);

    }  // end function testBoxing


    @Test
    public void testEnum(){
        Social social = Social.facebook;

        switch (social){
            case facebook:
                System.out.println("Facebook");
                break;
            case twitter:
                System.out.println("Twitter");
                break;
            default:
                System.out.println("No enumerator found");

        } // end switch

    }  // end function testEnum

    /**
     * Good enumerator example for practical use.
     */
    private enum Social{
        facebook(200), twitter(300);
        private int value;

        /**
         * Private constructor injecting the value
         * @param value
         */
        private Social(int value){
            this.value = value;
        }  // end constructor

        /**
         * Nice String with name and code of enumerator.
         * @return Returns the name and code of this enum constant, as contained in the declaration.
         */
        @Override
        public String toString(){
            return super.toString()+" ("+value+")";
        }

        public int value(){
            return value;
        }

        /**
         * Utility function to map int code to corresponding Social enumerator.
         *
         * @param value code of Social enumerator
         * @throws IllegalArgumentException if value not valid
         * @return The mapped Social entity
         */
        public static Social social(int value){
            for(Social social:Social.values()){
                if(social.equals(value))
                    return social;
            }
            // If we come here the int value is not valid
            throw new IllegalArgumentException("value = "+value+" is not a valid enumerator code!");
        }  // end public static function social

    }  // end enumerator Social
}  // end class TestDay2