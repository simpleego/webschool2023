package com.simple.threadex;

public class MyThread2Test {

    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("*");
        MyThread2 t2 = new MyThread2("^");

        t1.start();
        t2.start();
        System.out.println(Thread.currentThread()+"!!!!!!!!!!!!!!!!!!");
    }
}
