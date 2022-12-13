package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;


public class Main {

    public static ClassPathResource qualifiedResource(Class<?> clazz, String resourceSuffix) {
        return new ClassPathResource(String.format("%s-%s", clazz.getSimpleName(), resourceSuffix), clazz);
    }


    public static void main(String[] args) throws IOException {
//        ClassPathResource classPathResource = qualifiedResource(Main.class, "returnsNull.xml");
//
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        new XmlBeanDefinitionReader(factory).loadBeanDefinitions(classPathResource);
//
//        String factoryBean = factory.getBean("factoryBean").toString();
//        System.out.println(factoryBean);

//        var res = new ClassPathResource("Main-returnsNull.xml");
//
//        var myFile = res.getFile();
//        var lines = Files.readAllLines(myFile.toPath());
//
//        System.out.println(lines);

//        BeanFactory factory = new ClassPathXmlApplicationContext("quickstart-byname.xml");
//        Person person =  factory.getBean(Person.class);
//        System.out.println(person);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickstartConfiguration.class);
        Person person = ctx.getBean(Person.class);

        System.out.println(person);

    }


    public static class NullReturningFactoryBean implements FactoryBean<Object> {

        @Override
        public Object getObject() {
            return "123";
        }

        @Override
        public Class<?> getObjectType() {
            return String.class;
        }

        @Override
        public boolean isSingleton() {
            return true;
        }
    }


}