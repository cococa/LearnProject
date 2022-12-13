package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnn {

    @Test
    private void test1(){
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickstartConfiguration.class);
//        Person person = ctx.getBean(Person.class);
//        System.out.println(person);

        System.out.println("123");
        assert true;
    }



}
