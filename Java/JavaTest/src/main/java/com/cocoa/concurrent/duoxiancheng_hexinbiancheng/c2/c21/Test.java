package com.cocoa.concurrent.duoxiancheng_hexinbiancheng.c2.c21;

public class Test {

    //  方法中的变量一定是线程安全的

    public void pp() {
        int a = 0;
        while (a != 10) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
        }
        System.out.println(Thread.currentThread().getName() + "---" + a);
    }

    public  void testC211() {
        for (int i = 0; i < 10; i++) {
            Thread  t = new Thread(new Runnable() {
                @Override
                public void run() {
                    pp();
                }
            });
            t.start();
        }
    }


    int a  = 0;
    public  void pp2() {
        int count = 0;
        while (count!= 10) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "---" + a);
    }


    public  void testC212() {
        for (int i = 0; i < 10; i++) {
            Thread  t = new Thread(new Runnable() {
                @Override
                public void run() {
                    pp2();
                }
            });
            t.start();
        }
    }

    /**
     * 解决testC212的问题就是加锁
     * tips: 只有共享资源的读写才需要做同步
      */
    public  void testC213() {
        final Object o = new Object();
        for (int i = 0; i < 10; i++) {
            Thread  t = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o){
                        pp2();
                    }
                }
            });
            t.start();
        }

    }



    public static void main(String[] args) {
        Test test = new Test();
        test.testC212();
    }

}
