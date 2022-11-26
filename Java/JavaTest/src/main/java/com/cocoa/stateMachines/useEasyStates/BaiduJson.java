package com.cocoa.stateMachines.useEasyStates;

import org.jeasy.states.api.FiniteStateMachine;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;
import org.jeasy.states.api.Transition;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;

import java.util.HashSet;
import java.util.Set;


/**
 *   参考实现   https://en.wikipedia.org/wiki/Finite-state_machine
 *   文中参考例子 : 投币闸机（旋转门）
 *   正常的流程，闸机锁着--->用户投币或刷卡--->闸机解锁--->用户推动旋转门经过--->闸机锁住
 *   **** 锁的时候必须要刷刷卡才能解锁，解锁后必须要推动才能会到锁定状态
 *
 *   把上面的流程对应到easyStates 里，就是下面的 S 表示State ，E 表示 Event
 *   locked（S）--->  CoinEvent（E）---> unlocked（S）--->  PushEvent（E）---> locked（S）
 *
 *
 *
 *
 *

 */
public class BaiduJson {

        @org.junit.Test
        public void test() throws FiniteStateMachineException {

            State locked = new State("locked");
            State unlocked = new State("unlocked");

            Set<State> states = new HashSet<>();
            states.add(locked);
            states.add(unlocked);


            System.out.println(locked);


            Transition unlock = new TransitionBuilder()
                    .name("unlock")
                    .sourceState(locked)
                    .eventType(CoinEvent.class)
                    .eventHandler(new UnLock())
                    .targetState(unlocked)
                    .build();

            Transition pushLocked = new TransitionBuilder()
                    .name("pushLocked")
                    .sourceState(locked)
                    .eventType(PushEvent.class)
                    .targetState(locked)
                    .build();

            Transition lock = new TransitionBuilder()
                    .name("lock")
                    .sourceState(unlocked)
                    .eventType(PushEvent.class)
                    .eventHandler(new Lock())
                    .targetState(locked)
                    .build();

            Transition coinUnlocked = new TransitionBuilder()
                    .name("coinUnlocked")
                    .sourceState(unlocked)
                    .eventType(CoinEvent.class)
                    .targetState(unlocked)
                    .build();



            FiniteStateMachine turnstileStateMachine = new FiniteStateMachineBuilder(states, locked)
                    .registerTransition(lock)
                    .registerTransition(pushLocked)
                    .registerTransition(unlock)
                    .registerTransition(coinUnlocked)
                    .build();

            turnstileStateMachine.fire(new OntherEvent());

            System.out.printf("----"+ turnstileStateMachine.getCurrentState().getName());

        }

}
