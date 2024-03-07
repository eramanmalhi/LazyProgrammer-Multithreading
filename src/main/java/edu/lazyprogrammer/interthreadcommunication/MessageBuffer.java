package edu.lazyprogrammer.interthreadcommunication;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageBuffer {
    private String message;
    private boolean messageAvailable;

    public synchronized void sendMessage(String message){
            while(messageAvailable){
                try {
                    // Wait for the reader to read the message
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MessageBuffer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.message=message;
            messageAvailable=true;
            System.out.println("Message Sent: "+message);
            notify();
    }
    
    public synchronized void readMessage() {
        while(!messageAvailable){
            try {
                // Wait for the sender to send a message
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(MessageBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Message Received: "+message);
        messageAvailable=false;
        notify();
    }
}
