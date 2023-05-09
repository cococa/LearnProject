package com.cocoa.pattern.proxy.staticProxy;

public class ProxyLogger{


    private final IPlayer player;

    public ProxyLogger(IPlayer player){
      this.player = player;
    }


    public  void login(){
      System.out.println("ProxyLogger ==> player is playing");
      player.login();
      System.out.println("ProxyLogger ==> player is stop Play");
    }



}
