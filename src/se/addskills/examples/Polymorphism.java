package se.addskills.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by purple.tim on 24/5/2016.
 */
public class Polymorphism {

    public static void main(String[] args){
        //List<? extends Feed> feeds = Arrays.asList(new Facebook("Facebook comment"), new Twitter("Twitter Tweet"));
        List<Feed> feeds = new ArrayList<>();
        feeds.add(new Facebook("Facebook comment"));
        feeds.add(new Twitter("Twitter Tweet"));

        for(Feed feed : feeds){
            System.out.println(feed.getMessage());
            if(feed instanceof Facebook){
                System.out.println("instanceof Facebook - "+((Facebook)feed).facebook());
            }else if(feed instanceof Twitter){
                System.out.println("instanceof Twitter - "+((Twitter)feed).tweet());
            }
        }

    }


    private static abstract class Feed{
        public abstract String getMessage();
    }

    private static class Facebook extends Feed{
        private String comment;

        Facebook(String comment){
            this.comment = comment;
        }

        public String facebook(){
            return comment;
        }

        @Override
        public String getMessage() {
            return String.format("[Facebook] %s", comment);
        }
    }

    private static class Twitter extends Feed{
        private String tweet;

        public Twitter(String tweet){
            this.tweet = tweet;
        }

        public String tweet(){
            return tweet;
        }

        @Override
        public String getMessage() {
            return String.format("[Twitter] %s", tweet);
        }
    }

}