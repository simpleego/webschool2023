package com.simple.threadex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDownTest extends JFrame {
    private JLabel label;
    private JButton btnStart;
    class MyThread extends Thread {
        public void run(){
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
    CountDownTest(){
        setTitle("카운트 다운");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 객체 생성
        label = new JLabel("Start");
        label.setFont(new Font("Serif",Font.BOLD, 100));

        Thread downCouter = new MyThread();
        btnStart = new JButton("시작");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downCouter.start();
            }
        });
        // 객체 등록
        add(label, BorderLayout.CENTER);
        add(btnStart,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountDownTest();

        Runnable task = ()->{
            for(int i=10; i>=0; i--){
                System.out.print(i+" ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task).start();
    }
}
