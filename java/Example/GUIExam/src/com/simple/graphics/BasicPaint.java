package com.simple.graphics;

import javax.swing.*;

public class BasicPaint {

    public static void main(String[] args) {
        JFrame win = new JFrame("그래픽 기초 프로그램");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500,500);
        win.setResizable(true);

        win.add(new MyPanel());
        win.setVisible(true);
    }
}
