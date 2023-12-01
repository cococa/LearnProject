package com.cocoa.proxy.custom;

import java.lang.reflect.Method;

public class zxzz implements com.cocoa.proxy.IProductService{
    MyInvocationHandler h;
    public zxzz(MyInvocationHandler h) {
        this.h = h;
    }
    @Override
    public java.lang.String getInfo(){
        try{
            Method m = com.cocoa.proxy.IProductService.class.getMethod("getInfo",new Class[]{});
            this.h.invoke(this,m,null);
        }catch(Throwable e){e.printStackTrace();}
        return null;
    }
}