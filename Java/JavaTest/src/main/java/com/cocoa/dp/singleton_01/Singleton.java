package com.cocoa.dp.singleton_01;

public class Singleton {

    private Singleton(){

    }
    private static Singleton instance  =null;

	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
