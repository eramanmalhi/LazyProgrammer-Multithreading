package edu.lazyprogrammer.interthreadcommunication;
public class CommunicationDemo {
    public static void main(String[] args) {
        MessageBuffer buffer=new MessageBuffer();
        Thread senderThread=new Thread(()->{
        for(int i=0;i<10;i++){
            buffer.sendMessage("Message-"+i);
        }
        });
        
        Thread readerThread=new Thread(()->{
            for(int i=0;i<10;i++){
            buffer.readMessage();
        }
        });
        senderThread.start();
        readerThread.start();
    }
}
