package se.edument.recap.chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 2015-05-23.
 */
public class SimpleLogger implements Logger{
    private List<String> posts;
    private  boolean isEnabled;

    public SimpleLogger(){
        posts = new ArrayList<>();
    }

    @Override
    public void log(String message){
        if(isEnabled)
            posts.add(message);
    }  // end function log

    @Override
    public <T> void logType(T log) {
        if(log instanceof String){
            posts.add((String)log);
        }
    }

    @Override
    public int count(){
        return posts==null?0:posts.size();
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}  // end class Logger
