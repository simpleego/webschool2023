package com.simple.threadex;

class MyThread3 extends Thread {
    int sum=0;

    public int getSum() {
        return sum;
    }

    public void run(){
        for (int i=0; i<=10; i++){
            System.out.println("MyThread3 :"+i);
            sum += i;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadJoin {

    public static void main(String[] args) {
        MyThread3 t3 = new MyThread3();
        t3.start();
        System.out.println("Thread가 종료될때까지 기다립니다.");
        System.out.println("합계 :"+t3.getSum());
        try{
            t3.join();   // 해당 쓰레드가 종료될때까지 기다립니다.
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("종료되었습니다.");
        System.out.println("합계 :"+t3.getSum());
    }
}
