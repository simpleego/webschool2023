package com.simple.threadex;

class ThreadB extends Thread {
    int total;
    public void run(){
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "를 더합니다.");
                total += i;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notify();// 스레드가 공유데이터(total)를 사용한 일을 마치고 나왔다.
        }
    }
}

public class ThreadWaitNotify {
    public static void main(String[] args) {

        ThreadB thB = new ThreadB();
        thB.start();
        synchronized (thB) {
            try {
                System.out.println("b가 완료될때까지 기다립니다.");
                thB.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 깨어난 후에 결과값을 출력
        System.out.println("Total is : "+thB.total);

    }
}
