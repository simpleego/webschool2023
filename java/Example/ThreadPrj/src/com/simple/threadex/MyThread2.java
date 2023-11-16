package com.simple.threadex;

public class MyThread2 extends Thread {
    String str;

    public MyThread2(String str) {
        this.str = str;
    }

    public void run(){
        System.out.println(Thread.currentThread());
        for(int i=0; i<10; i++){
            System.out.print(str+",");
            try {
                Thread.sleep((int)(Math.random()*1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
