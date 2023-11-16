package com.simple.threadex;

class MusicBox {
    //신나는 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public synchronized void playMusicA(){
        for(int i = 0; i < 10; i ++){
            System.out.println("신나는 음악!!!");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    } //playMusicA

    //슬픈 음악!!!이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public synchronized void playMusicB(){
        for(int i = 0; i < 10; i ++){
            System.out.println("슬픈 음악!!!");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    } //playMusicB

    //카페 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public synchronized void playMusicC(){
        for(int i = 0; i < 10; i ++){
            System.out.println("카페 음악!!!");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    } //playMusicC
}

class MusicPlayer extends Thread {
    int type;
    MusicBox musicBox;
    // 생성자로 부터 musicBox와 정수를 하나 받아들여서 필드를 초기화
    public MusicPlayer(int type, MusicBox musicBox){
        this.type = type;
        this.musicBox = musicBox;
    }
    // type이 무엇이냐에 따라서 musicBox가 가지고 있는 메소드가 다르게 호출
    public void run(){
        switch(type){
            case 1 : musicBox.playMusicA(); break;
            case 2 : musicBox.playMusicB(); break;
            case 3 : musicBox.playMusicC(); break;
        }
    }
}

public class MusicBoxExam {

    public static void main(String[] args) {
        MusicBox musicBox = new MusicBox();

        MusicPlayer  kim = new MusicPlayer(1,musicBox);
        MusicPlayer  lee = new MusicPlayer(2,musicBox);
        MusicPlayer  kang = new MusicPlayer(3,musicBox);

        lee.start();
        kim.start();
        kang.start();
    }
}
