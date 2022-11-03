package com.cocoa.pattern.observer.demo2;

import com.cocoa.pattern.observer.demo3.LiSi;

public class HanFeiZi implements IHanFeiZi{

	public com.cocoa.pattern.observer.demo3.LiSi mLiSi = new LiSi();


	public void haveFun(){
		
		System.out.println(" hanfeizi is haveFun");

		mLiSi.update(" hanfeizi is haveFun");

	}

	public void haveBreakfast(){
		System.out.println(" hanfeizi is haveBreakfast");
	}

} 
