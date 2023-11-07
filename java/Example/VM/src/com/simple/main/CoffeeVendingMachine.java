package com.simple.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeVendingMachine extends JFrame implements ActionListener {

    private int inMoney;
    JButton milkButton, blackButton, sugarButton;
    JLabel milkLabel, blackLabel, sugarLabel;

    JLabel coinInputLabel;
    JTextField coinInputTextField;
    JButton coinInputButton;
    public CoffeeVendingMachine()  {
        setTitle("커피 자판기");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,3));

        // 버튼 생성
        milkButton = new JButton("밀크커피");
        sugarButton = new JButton("설탕커피");
        blackButton = new JButton("블랙커피");

        milkLabel = new JLabel("300원");
        sugarLabel = new JLabel("200원");
        blackLabel = new JLabel("200원");

        coinInputLabel = new JLabel("동전 입력 : ");
        coinInputTextField = new JTextField(5);
        coinInputButton = new JButton("동전입력");

        milkButton.setEnabled(false);
        sugarButton.setEnabled(false);
        blackButton.setEnabled(false);

        milkButton.addActionListener(this);
        sugarButton.addActionListener(this);
        blackButton.addActionListener(this);
        coinInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coins = coinInputTextField.getText();
                if(coins.length() > 1) {
                    inMoney += Integer.parseInt(coins);
                    System.out.println("잔액 : " + inMoney);
                }else {
                    JOptionPane box = new JOptionPane();
                    box.showMessageDialog(null,"동전 입력하세요!!");
                }

                if(inMoney >= 300){
                    milkButton.setEnabled(true);
                    sugarButton.setEnabled(true);
                    blackButton.setEnabled(true);
                } else if (inMoney >=200) {
                    sugarButton.setEnabled(true);
                    blackButton.setEnabled(true);
                }else {
                    milkButton.setEnabled(false);
                    sugarButton.setEnabled(false);
                    blackButton.setEnabled(false);
                }
            }
        });

        // 버튼 등록
        add(milkButton);
        add(sugarButton);
        add(blackButton);

        add(milkLabel);
        add(sugarLabel);
        add(blackLabel);

        add(coinInputLabel);
        add(coinInputTextField);
        add(coinInputButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == milkButton){
            System.out.println("밀커커피 선택");
            JOptionPane box = new JOptionPane();
            box.showMessageDialog(null,"밀커커피 선택");
        } else if (e.getSource() == sugarButton) {
            System.out.println("설탕커피 선택");
        }else {
            System.out.println("블랙커피 선택");
        }

    }

    public static void main(String[] args) {
         CoffeeVendingMachine vm =  new CoffeeVendingMachine();
    }
}
