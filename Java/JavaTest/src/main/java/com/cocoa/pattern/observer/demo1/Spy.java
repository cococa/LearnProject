package com.cocoa.pattern.observer.demo1;

public class Spy implements Runnable{


	private final HanFeiZi  mHanFeiZi ;
	private final LiSi mLiSi;

	public Spy(HanFeiZi hanFeiZi, LiSi liSi){
			this.mHanFeiZi = hanFeiZi;
			this.mLiSi = liSi;
	}

	@Override
	public void run(){
		while(true){
		try{
			Thread.sleep(2000);
			System.out.println(String.valueOf(this.mHanFeiZi.fun));
		}catch(Exception e){

		}
			
			if(this.mHanFeiZi.fun){
				this.mLiSi.update("hanfeizi is haveFun liSi will report");
				this.mHanFeiZi.fun = false;
			}
		}
	}
}