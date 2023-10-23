package com.simple.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDivider implements ActionListener {

    WindowFrame win;
    public MyDivider(WindowFrame win) {
        this.win = win;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String num1_ = win.getTf1();
        String num2_ = win.getTf2();
        double result = 0;
        if(Integer.parseInt(num2_) != 0){
            result = Double.parseDouble(num1_) /
                    Double.parseDouble(num2_);
            String result_ = String.format("%.2f", result);
            win.setTf3(result_);
            return;
        }

        // 메시지 박스 띄우기
        JOptionPane.showMessageDialog(null, "0으로 나눌 수 없습니다.");
        win.setTf3(result+"으로 나눌 수 없습니다 !!"); //String.valueOf(sum));
    }
}
