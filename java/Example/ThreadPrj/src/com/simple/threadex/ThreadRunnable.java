package com.simple.threadex;
class MyRunnable implements Runnable{
    String myName;

    MyRunnable(String str){
        myName = str;
    }

    @Override
    public void run() {
        for(int i=10; i>=0; i--){
            System.out.print(myName+i+" ");
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}


public class ThreadRunnable {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("A");
        MyRunnable myRunnable1 = new MyRunnable("B");
        Thread th1 = new Thread(myRunnable);
        Thread th2 = new Thread(myRunnable1);
        th1.start();
        th2.start();
    }

}
