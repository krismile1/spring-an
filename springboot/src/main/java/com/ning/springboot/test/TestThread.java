package com.ning.springboot.test;

/**
 * Create By : an
 * Time : 2019/2/14 9:45
 * Description :
 */

class ThreadDemo1 extends Thread{
    public ThreadDemo1(String str){
        super(str);
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++) {
            System.out.println(this.getName());

            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class TestThread {
    public static void main(String[] args) {
        ThreadDemo1 t1 = new ThreadDemo1("线程1");
        ThreadDemo1 t2 = new ThreadDemo1("线程2");
        ThreadDemo1 t3 = new ThreadDemo1("线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}
