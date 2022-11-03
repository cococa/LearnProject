package com.cocoa.pattern.observer.demo3;

public class LiSi implements Observer{


	public void update(String context){
		System.out.println(" start report ");
		report(context);
		System.out.println(" end report ");	
	}

	public void report(String reportMsg){
		System.out.println(" report "+ reportMsg);
	}

}