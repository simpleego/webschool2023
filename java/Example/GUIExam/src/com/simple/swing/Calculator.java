package com.simple.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField inputSpace;

    public Calculator() throws HeadlessException {
        setLayout(null);// 배치관리를 내가 직접하겠다.

        inputSpace = new JTextField();
        inputSpace.setEditable(false);
        inputSpace.setBackground(Color.darkGray);
        inputSpace.setHorizontalAlignment(JTextField.RIGHT);
        inputSpace.setFont(new Font("ITALIC",Font.BOLD,50));
        inputSpace.setBounds(0,0,500,100);

        JPanel buttonPanel = new JPanel();// 컨테이너, 컨트롤을 담는다.
        buttonPanel.setLayout(new GridLayout(4,4,20,20));
        buttonPanel.setBounds(0,100,500,380);

        String[] buttonOrder = {"AC","/","x","=",
                                "7","8","9","+",
                                "4","5","6","-",
                                "1","2","3","0"};
        JButton[] buttons = new JButton[buttonOrder.length];

        for (int i=0; i<buttonOrder.length; i++){
            buttons[i] = new JButton(buttonOrder[i]);
            buttons[i].setFont(new Font("ITALIC",Font.BOLD,25));
            // 버튼 이벤트 등록
            buttons[i].addActionListener(this);

            // 꾸미기 추가
            if(buttonOrder[i] == "AC"){
                buttons[i].setBackground(new Color(0xff9300));
                buttons[i].setOpaque(true);
            }else if((i>=4 && i<=6)||
                    (i>=8 && i<=10) ||
                    (i>=12 && i<=14)){
               buttons[i].setBackground(Color.black);
               buttons[i].setOpaque(true);
            }else {
                buttons[i].setBackground(Color.gray);
                buttons[i].setOpaque(true);
            }

            buttons[i].setForeground(Color.white);
            buttons[i].setBorderPainted(false);
            buttonPanel.add(buttons[i]);
        }

        this.add(inputSpace);
        add(buttonPanel);
        setTitle("계산기");
        setSize(300,400);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
