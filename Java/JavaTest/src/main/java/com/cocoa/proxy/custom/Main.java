package com.cocoa.proxy.custom;

import com.cocoa.proxy.IProductService;
import com.cocoa.proxy.IUserService;

/**
 * https://developer.aliyun.com/article/708898
 */
public class Main {

    public static void main(String[] args) {


//https:developer.aliyun.com/article/708898

//        System.out.println(String.class.getClassLoader());
//        System.out.println(HashMap.class.getClassLoader());
//
//        //sun.misc.Launcher$AppClassLoader
//        System.out.println(MyClassLoader.class.getClassLoader().getClass().getName());
//
//        //sun.misc.Launcher$AppClassLoader
//        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());


        UserInvocationHandler userInvocationHandler = new UserInvocationHandler();
        Object obj = MyProxy.newProxyInstance(new MyClassLoader(), new Class[]{IProductService.class}, userInvocationHandler);
        if (obj instanceof IProductService) {
            IProductService productService = (IProductService) obj;
            System.out.println(productService.getInfo());

        }

    }

}
