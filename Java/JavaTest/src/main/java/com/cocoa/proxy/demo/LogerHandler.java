package com.cocoa.proxy.demo;

import com.cocoa.proxy.IProductService;
import com.cocoa.proxy.ProductServiceImpl;
import com.cocoa.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class LogerHandler implements InvocationHandler {

    /**
     *  使用动态代理实现日志记录
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        LogerHandler logerHandler = new LogerHandler();
        IProductService iProductService = (IProductService) Proxy.newProxyInstance(logerHandler.getClass().getClassLoader(), new Class[]{IProductService.class}, logerHandler);
        String info = iProductService.getInfo();
        System.out.println(info);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(new Date());
        ProductServiceImpl obj = ProductServiceImpl.class.newInstance();
        Object invoke = method.invoke(obj, args);
        System.out.println(new Date() + "----" + invoke);
        return invoke;
    }
}
