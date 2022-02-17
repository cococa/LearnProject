package com.cocoa.stateMachines.useStateDesignPattern;


class Context{

    private State state;

    public Context(){
        this.state = new StateA();    
    }

    public void setState(State  state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

}


abstract class State{

    abstract void handle(Context context);

}

class StateA extends State{

    public void handle(Context context){
        System.out.println("Im A");
        context.setState(new StateB());  
    }

}

class StateB extends State{

    public void handle(Context context){
        System.out.println("Im B");
        context.setState(new StateA());  
    }

}




public class StatePatternClient {


    public static void main(String[] args){
        Context context = new Context();    //创建环境      
        context.getState().handle(context);
        context.getState().handle(context);
        context.getState().handle(context);
    }

    
}
