package com.cocoa.stateMachines.useEasyStates;

import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

public class Lock implements EventHandler {
    @Override
    public void handleEvent(Event event) throws Exception {
        System.out.println("--handleEvent-Lock-"+ event);
    }
}
