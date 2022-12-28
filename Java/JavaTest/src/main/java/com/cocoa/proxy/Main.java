package com.cocoa.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


//        User u1 = new User("u1",1);
//        User u2 = new User("u2",2);
//        User u3 = new User("u3",2);
//        User u4 = new User("u4",1);
//
//        List<User> list = new ArrayList<>();
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
//        list.add(u4);
//        Map<Integer, List<User>> resultMap = list.stream().collect(Collectors.groupingBy(User::getId));
//        System.out.println(resultMap.get(2));


        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //很神奇，一直输出true
                System.out.println(proxy instanceof IProductService);
                System.out.println(proxy instanceof IUserService);
                if(method.getName().equals("findUserById")) {
                    Class clz = UserServiceImpl.class;
                    Object target = clz.newInstance();
                    return method.invoke(target, args);
                }

                if(method.getName().equals("getInfo")) {
                    Class clz = ProductServiceImpl.class;
                    Object target = clz.newInstance();
                    return method.invoke(target, args);
                }

                return null;
            }
        };

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
