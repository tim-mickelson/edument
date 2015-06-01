package se.addskills.day2.excercise7;

import se.addskills.day1.excercise4.CustomLogger;
import se.addskills.day1.excercise4.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise seven
 *
 * This exercise will simulate a chat with some participants. The messages will just be put out on standard output
 * instead of actually being sent to a receiver. The exercise should throw a custom Exception on bad receiver or sender.
 * The custom exception will hold an encapsulated custom enumerator for different HTTP error codes.
 *
 * 1) Create interface Logger with method log(String message).
 * 2) Let CustomLogger from exercise four implement the logger.
 * 3) Create class ChatSession with list of encapsulated participants and instance of Logger interface injected in constructor or set with setter.
 * 4) Create DTO bean Participant as inner class with String attribute ip
 * 5) Create HttpCode enumerator with HTTP error codes.
 * 6) Create class HttpException that extends Exception class and encapsulates HttpCode attribute.
 * 7) Create a MessageDispatcher class with sendMessage function that takes receiver, sender and message in input and specially throws an HttpException.
 * 8) Create a situation where exception can be forced and print cause to standard output.
 * 9) Create main function and test the chat with the case all is good and then with an exception.
 */

/**
 * Class that simulates chat with given participant. On error throws custom Exception with custom enumerator.
 *
 * @author Tim Mickelson
 * @since 27/05/2015
 */
public class ChatSession {
    Logger logger = null;
    MessageDispatcher dispatcher = new MessageDispatcher();
    List<Participant> participants = new ArrayList<>();

    public ChatSession(Logger logger){
        this.logger = logger;
    }

    /**
     * Just add participant to list with no checks.
     * @param participant
     */
    public void addParticipant(Participant participant){
        participants.add(participant);
    }

    /**
     * Run some basic tests to test the CustomLogger and the HttpException
     * @param args
     */
    public static void main(String[] args){
        Logger logger = new CustomLogger();
        ChatSession session = new ChatSession(logger);
        Participant participant = new Participant();
        participant.setIp("126.0.0.1");

        Participant badParticipant = new Participant();
        badParticipant.setIp("192.168.1.117");

        // Send a good message, log with CustomLogger
        session.addParticipant(badParticipant);
        session.sendMessage(participant, "some message");
        // Set ip null, now HttpException
        badParticipant.setIp(null);
        session.sendMessage(participant, "some message");
    }  // end function main

    /**
     * Send message to all participants of chat.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     * @param sender Originating user of message.
     * @param msg The message
     */
    public void sendMessage(Participant sender, String msg){
        for (Participant receiver : participants) {
            // Send the message
            try {
                dispatcher.sendMessage(sender, receiver, msg);
            } catch (HttpException e) {
                // Dont block, keep sending to other participants
                logger.log(String.format("Error %s", e.getHttpError().toString()));
            }
        }

    }

    /**
     * Dispatcher class that will send message to receiver. In this case just print to standard output.
     *
     * @author Tim Mickelson
     * @since 27/05/2015
     */
    private class MessageDispatcher{
        /**
         * Send the message to receiver.
         * @param sender Originating Participant
         * @param receiver Destinated Participant
         * @param message The message
         * @throws HttpException on network problems
         */
        public void sendMessage(Participant sender, Participant receiver, String message) throws HttpException {
            if(receiver.getIp()==null){
                throw new HttpException(HttpException.HttpError.NOT_FOUND, "Participant ip not definied");
            }
            System.out.println(String.format("%s sent to ip %s from ip %s", message, receiver.getIp(), sender.getIp()));
        }
    }  // end class MessageDispatcher

    /**
     * Simple DTO for chat participant.
     * @author Tim Mickelson
     * @since 27/05/2015
     */
    private static class Participant{
        private String ip;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

    }  // end class Participant

}  // end public class ChatSession