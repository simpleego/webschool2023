package com.simple.threadex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDownTest1 extends JFrame implements Runnable {
    private JLabel label;
    private JButton btnStart;
    private JButton btnStop;

    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread downCouter;

    @Override
    public void run() {
        while(!stopped){
            if(!suspended){
                for(int i=60; i>=0; i--){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    label.setText(i+"");
                }
            }
        }

    }


    void threadStart(){
        downCouter.start();
    }
    void threadStop(){
        stopped =  true;
    }
    void threadSuspended(){
        suspended = true;
    }
    void threadResume(){
        suspended = false;
    }

    CountDownTest1(){
        setTitle("카운트 다운");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 객체 생성
        label = new JLabel("Start");
        label.setFont(new Font("Serif",Font.BOLD, 100));

        downCouter = new MyThread();
        btnStart = new JButton("시작");
        btnStop = new JButton("일시멈춤");
        btnStart.addActionListener((ActionEvent e)-> {
                downCouter.start();
        });

        btnStop.addActionListener((ActionEvent e)-> {
            downCouter. threadStop();
        });

        // 객체 등록
        add(label, BorderLayout.CENTER);
        add(btnStart,BorderLayout.SOUTH);
        add(btnStop,BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountDownTest1();
    }
}
