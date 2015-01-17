package events.impl;

import events.EventHandler;
import events.Producer;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 1/17/15
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerImpl implements Producer {
    private int producerNumber;

    public ProducerImpl(int producerNumber){
        this.producerNumber = producerNumber;
    }

    EventHandler handler = new EventHandlerImpl();
    private void event(){
        System.out.println("event in producer #"+ producerNumber+" occurred");
        handler.onEvent(producerNumber);
    }

    public void run() {
        while(true){
            Random rnd = new Random();
            try {
                Thread.sleep(rnd.nextInt(10000)+2000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            event();
        }
    }

    public String call() throws Exception {
        Random rnd = new Random();
        try {
            Thread.sleep(rnd.nextInt(10000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        event();
        return "Greeting from producer #"+producerNumber;
    }
}
