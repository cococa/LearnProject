package com.cocoa.pattern.observer.demo4;

public class Test{
	public static void main(String[] args){
		HanFeiZi hanFeiZi  = new HanFeiZi();
		
		hanFeiZi.addObserver(new LiSi());

		hanFeiZi.haveFun();

	}
}