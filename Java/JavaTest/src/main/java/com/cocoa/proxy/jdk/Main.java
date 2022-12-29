package com.cocoa.proxy.jdk;

import com.cocoa.proxy.IProductService;
import com.cocoa.proxy.IUserService;
import com.cocoa.proxy.ProductServiceImpl;
import com.cocoa.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //很神奇，一直输出true
                System.out.println(proxy instanceof IProductService);
                System.out.println(proxy instanceof IUserService);
                if (method.getName().equals("findUserById")) {
                    Class clz = UserServiceImpl.class;
                    Object target = clz.newInstance();
                    return method.invoke(target, args);
                }

                if (method.getName().equals("getInfo")) {
                    Class clz = ProductServiceImpl.class;
                    Object target = clz.newInstance();
                    return method.invoke(target, args);
                }

                return null;
            }
        };
        // 这里的 class 数组必须是接口，否则会出错
        Object proxy = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class, IProductService.class}, handler);
        if (proxy instanceof IUserService) {
            IUserService userService = (IUserService) proxy;
            User userById = userService.findUserById(1);
            System.out.println(userById);
        }

        if (proxy instanceof IProductService) {
            IProductService productService = (IProductService) proxy;
            String info = productService.getInfo();
            System.out.println(info);
        }


    }

}
