package se.addskills.day2.excercise7;

import se.addskills.day1.excercise4A_tim.CustomLogger;
import se.addskills.day1.excercise4A_tim.Logger;
import  se.addskills.day2.excercise7.ChatSession.Participant;

/**
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
 *
 */
public class Program {

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

}  // end class Program