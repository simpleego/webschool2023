package com.simple.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class WindowFrame extends JFrame {
    // GUI 멤버
    private final JButton btnAdd,btnSub,btnMul,btnDiv;
    private JTextField tf1, tf2, tf3;
    private JLabel label1, label2, label3;

    public WindowFrame(){

        // 윈도우 초기화
        this.setTitle("계산기");
        this.setSize(100,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);

        // 멤버 객체 생성 및 초기화
        tf1=new JTextField(20);
        tf2=new JTextField(20);
        tf3=new JTextField(20);
        label1 = new JLabel("숫자1");
        label2 = new JLabel("숫자2");
        label3 = new JLabel("결과");

        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("x");
        btnDiv = new JButton("/");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1_ = tf1.getText();
                String num2_ = tf2.getText();
                int sum = Integer.parseInt(num1_) +
                        Integer.parseInt(num2_);
                tf3.setText(sum+""); //String.valueOf(sum));
            }
        });

        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1_ = tf1.getText();
                String num2_ = tf2.getText();
                int result = Integer.parseInt(num1_) -
                        Integer.parseInt(num2_);
                tf3.setText(result+""); //String.valueOf(sum));
            }
        });

        btnMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1_ = tf1.getText();
                String num2_ = tf2.getText();
                int result = Integer.parseInt(num1_) *
                        Integer.parseInt(num2_);
                tf3.setText(result+""); //String.valueOf(sum));
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1_ = tf1.getText();
                String num2_ = tf2.getText();
                double result = 0;
                if(Integer.parseInt(num2_) != 0){
                    result = Double.parseDouble(num1_) /
                          Double.parseDouble(num2_);
                    String result_ = String.format("%.2f", result);
                    tf3.setText(result_); //String.valueOf(sum));
                    return;
                }
                // 메시지 박스 띄우기
                JOptionPane.showMessageDialog(null, "0으로 나눌 수 없습니다.");

                tf3.setText(result+"으로 나눌 수 없습니다 !!"); //String.valueOf(sum));

            }
        });

        add(label1);add(tf1);
        add(label2);add(tf2);
        add(label3);add(tf3);
        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowFrame();
    }

}
