package se.edument.recap.chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 2015-05-23.
 */
public class ChatSession {
    private final Logger logger;
    private final MessageDispatcher dispatcher;
    private List<Participant> participants;

    public ChatSession(Logger logger){
        dispatcher = new MessageDispatcher();
        participants = new ArrayList<>();
        this.logger = logger;
    }  // end constructor

    public void sendMessage(Participant sender, String msg){
        // Log message
        logger.log(String.format("%1$s sent: %2$s", sender.getHandle(), msg));
        // Send message to all participants
        for(Participant receiver:participants){
            // send the message
            dispatcher.sendMessage(sender, receiver, msg);
        }  // end loop participants
    }  // end function sendMessage

}  // end class ChatSession
