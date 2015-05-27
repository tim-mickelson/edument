package se.edument.exercise.seven;

import se.edument.exercise.four.CustomLogger;
import se.edument.exercise.four.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by purple.tim on 27/5/2015.
 */
public class ChatSession {
    Logger logger = new CustomLogger();
    MessageDispatcher dispatcher = new MessageDispatcher();
    List<Participant> participants = new ArrayList<>();

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
        ChatSession session = new ChatSession();
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
                logger.log(String.format("Error %s", e.getHttpCode().toString()));
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
                throw new HttpException(HttpException.HttpCode.NOT_FOUND, "Participant ip not definied");
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
        private String handle;
        private String firstName;
        private String lastName;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getHandle() {
            return handle;
        }

        public void setHandle(String handle) {
            this.handle = handle;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }  // end class Participant

}  // end public class ChatSession