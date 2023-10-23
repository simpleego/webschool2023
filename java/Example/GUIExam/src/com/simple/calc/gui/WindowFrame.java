package com.simple.calc.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowFrame extends JFrame implements ActionListener {
    // GUI 멤버
    private JButton btnAdd,btnSub,btnMul,btnDiv,btnPow, btnCompare;
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
        btnPow = new JButton("^");
        btnCompare = new JButton("?");

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

        // 람다식으로 이벤트 처리
        btnCompare.addActionListener(
            (ActionEvent e) -> {
                String num1_ = tf1.getText();
                String num2_ = tf2.getText();

                String result=label1.getText()+"과"+
                        label2.getText()+" 값이 같다";
                if(num1_.compareTo(num2_) > 0){
                    result = label1.getText()+"이 크다";
                }else if(num1_.compareTo(num2_) < 0){
                    result = label2.getText()+"가 크다";
                }
                tf3.setText(result);
            }
        );

        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(new MyDivider(this));
        btnPow.addActionListener(new MyPower());

        add(label1);add(tf1);
        add(label2);add(tf2);
        add(label3);add(tf3);
        add(btnAdd);add(btnSub);
        add(btnMul);add(btnDiv);
        add(btnPow);add(btnCompare);

        this.setVisible(true);
    }

    public String getTf1() {
        return tf1.getText();
    }
    public String getTf2() {
        return tf2.getText();
    }

    public void setTf3(String tf3) {
        this.tf3.setText(tf3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = 0;
        int num1 = Integer.parseInt(tf1.getText());
        int num2 = Integer.parseInt(tf2.getText());

        if(e.getSource() == btnSub){
            result = num1 - num2;
        }else {
            result = num1 * num2;
        }
        tf3.setText(result+""); //String.valueOf(sum));
    }

    // 내부 클래스 :  제곱계산을 처리
    public class MyPower implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double num1 = Double.parseDouble(tf1.getText());
            double num2 = Double.parseDouble(tf2.getText());
            double result = 0;
            result = Math.pow(num1,num2);
            tf3.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        WindowFrame win = new WindowFrame();
    }
}
