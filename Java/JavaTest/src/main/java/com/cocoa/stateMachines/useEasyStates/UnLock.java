package com.cocoa.stateMachines.useEasyStates;

import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

public class UnLock implements EventHandler {
    @Override
    public void handleEvent(Event event) throws Exception {
        System.out.println("--handleEvent-UnLock-"+ event);
    }
}
