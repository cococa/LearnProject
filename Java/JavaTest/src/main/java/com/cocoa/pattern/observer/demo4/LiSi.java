package com.cocoa.pattern.observer.demo4;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer{

	@Override
	public void update(Observable o, Object obj){
		System.out.println(" start report ");
		report((String)obj);
		System.out.println(" end report ");	
	}

	public void report(String reportMsg){
		System.out.println(" report "+ reportMsg);
	}

}