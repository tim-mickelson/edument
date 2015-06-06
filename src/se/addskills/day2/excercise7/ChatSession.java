package se.addskills.day2.excercise7;

import se.addskills.day1.excercise4A_tim.CustomLogger;
import se.addskills.day1.excercise4A_tim.Logger;

import java.util.ArrayList;
import java.util.List;

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
    public static class Participant{
        private String ip;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

    }  // end class Participant

}  // end public class ChatSession