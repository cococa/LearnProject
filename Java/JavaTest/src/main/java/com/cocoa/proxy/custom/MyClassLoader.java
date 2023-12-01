package com.cocoa.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    private File baseDir;

    public MyClassLoader() {

        Class<MyClassLoader> clazz = MyClassLoader.class;
        String basePath = clazz.getResource("").getPath();
//        String basePath = clazz.getResource("/").getPath() +"com/nqmysb/myproxy/proxytools";
        this.baseDir = new java.io.File(basePath);
    }

    /**
     * 自定义类加载方法 ，加载自定义类
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取需要加载的类的全名  com.nqmysb.myproxy.proxytools.$Proxy0
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            //获取 class文件对象 E:\workspace\spring-source-analysis\spring-source-proxy\bin\com\nqmysb\myproxy\proxytools\$Proxy0.class
            File classFile = new File(baseDir, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    //根据class文件和类名生成class对象 并加载到JVM中
                    return defineClass(className, out.toByteArray(), 0, out.size());

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != in) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != out) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //删除Class文件
                    classFile.delete();
                }

            }
        }

        return null;
    }


}
