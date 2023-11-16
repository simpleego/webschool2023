package com.simple.threadex;

class MyThread1 extends Thread{
    public void run(){
        for (int i=10; i>= 0; i--){
            System.out.print(i+" ");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread1 = new MyThread1();
        Thread myThread2 = new MyThread1();

        for (int i=10; i>= 0; i--) {
            System.out.print(i + ", ");
            Thread.sleep(100);
        }
        myThread1.start();
        myThread2.start();
    }
}
