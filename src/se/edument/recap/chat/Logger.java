package se.edument.recap.chat;

/**
 * Created by Tim on 2015-05-23.
 */
public interface Logger {

    void log(String message);

    <T> void logType(T log);

    boolean isEnabled();

    int count();
}  // end interface Logger
