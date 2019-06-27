package com.ning.springboot.test;

import static java.lang.Thread.sleep;

/**
 * Create By : an
 * Time : 2019/2/12 15:42
 * Description :
 */
//    class B extends Object {
//        static{
//            System.out.println("Load B");
//        }
//        public B() {
//            System.out.println("CreateB");
//        }
//    }
//    class A extends B{
//        static{
//            System.out.println("LoadA");
//        }
//        public A() {
//            System.out.println("CreateA");
//        }
//    }
//    class Testclass{
//        public static void main (String[] args) {
//            new A();
//        }
//    }


// programme name TestThread;

// 声明一个子线程类Threaddemo;

class ThreadDemo extends Thread {

    public ThreadDemo(String str) {

        super(str);

    }

    public void run() {

        for (int i = 0; i < 20; i++) {

            System.out.println(" " + this.getName());

            try {

                sleep(300);

            } catch (InterruptedException e) {

                System.out.println(e.getMessage());

                return;

            }

        }

        System.out.println("  /end");

    }

}

public class TestClass {

    public static void main(String args[]) {

        ThreadDemo thread1 = new ThreadDemo("T1");

        ThreadDemo thread2 = new ThreadDemo("T2");

        ThreadDemo thread3 = new ThreadDemo("T3");

        thread1.start();

        thread2.start();

        thread3.start();

    }
}
