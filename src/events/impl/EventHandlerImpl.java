package events.impl;

import events.EventHandler;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 1/17/15
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventHandlerImpl implements EventHandler {
    public void onEvent(int producerNumber){
        System.out.println("event in producer #"+producerNumber+" handled");
    }
}
