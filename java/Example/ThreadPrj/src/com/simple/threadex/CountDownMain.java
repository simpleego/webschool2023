package com.simple.threadex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CountDownMain extends JFrame {
    JLabel label;
    JButton btnStart;
    JButton btnStop;
    CountDown countDown;

    public CountDownMain() {
        setTitle("카운트 다운");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 객체 생성
        label = new JLabel("Start");
        label.setFont(new Font("Serif", Font.BOLD, 100));


        btnStart = new JButton("시작");
        btnStop = new JButton("일시멈춤");
        btnStart.addActionListener((ActionEvent e) -> {
            countDown.threadStart();
        });

        btnStop.addActionListener((ActionEvent e) -> {
            countDown.th();
        });

        // 객체 등록
        add(label, BorderLayout.CENTER);
        add(btnStart, BorderLayout.SOUTH);
        add(btnStop, BorderLayout.EAST);

        setVisible(true);
    }

    public void setCountDown(CountDown countDown) {
        this.countDown = countDown;
    }

    public static void main(String[] args) {
        CountDownMain main = new CountDownMain();
        CountDown countDown1 = new CountDown(main);

        Thread th = new Thread(countDown1);
        main.setCountDown(countDown1);

        th.start();
    }
}
