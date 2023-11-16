package com.simple.main;

import com.simple.main.entity.Materials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.logging.Logger;

public class CoffeeVendingMachine extends JFrame implements ActionListener {

    private int inMoney; // 사용자가 입력한 돈
    private int money;// 자판기 수입

    private int returnMoney;  // 반환할 돈
    JButton milkButton, blackButton, sugarButton;
    JLabel milkLabel, blackLabel, sugarLabel;

    JLabel coinInputLabel;
    JTextField coinInputTextField;
    JButton coinInputButton;

    JLabel message;
    JLabel productOutLabel;
    Icon milkImg, sugarImg, blackImg;
    JButton coinReturnButton;

    CoinReturn coinReturn;
    Materials materials;
    public CoffeeVendingMachine()  {
        setTitle("커피 자판기");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,3));

        money = 0;
        inMoney = 0;

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

        // 상품 출구
        message = new JLabel("자판기 상태 : ");
        productOutLabel = new JLabel("");
        coinReturnButton = new JButton("동전반환");
        coinReturn = new CoinReturn(this);
        coinReturnButton.addActionListener(coinReturn);
        materials = new Materials(100,100,100);

        milkImg = new ImageIcon("milkOut.png");
        sugarImg = new ImageIcon("sugarOut.png");
        blackImg = new ImageIcon("blackOut.png");
        productOutLabel.setIcon(null);
        //productOutLabel.setBackground();

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
                JOptionPane box = new JOptionPane();

                if(coins.length() > 1) {
                    try{
                        inMoney += Integer.parseInt(coins);
                    }catch (NumberFormatException except){
                        box.showMessageDialog(null,"정수를 입력");
                    }
                    System.out.println("잔액 : " + inMoney);
                }else {
                    box = new JOptionPane();
                    box.showMessageDialog(null,"동전 입력하세요!!");
                }

                // 동전을 화면에 표시
                String inMoney_ =
                        coinInputLabel.getText().substring(0,7)+inMoney+"원";
                coinInputLabel.setText(inMoney_);

                //
                processButton(inMoney);
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

        add(message);
        add(productOutLabel);
        add(coinReturnButton);

        setVisible(true);
    }

    public int getInMoney(){
        return inMoney;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //productOutLabel.setIcon(null);
            System.out.println("밀크"+milkImg);

        if(e.getSource() == milkButton){
            productOutLabel.setIcon(milkImg);
            //밀크커피 제조
            makeCoffee("milk");
            inMoney -= 300;
            money += 300;
        } else if (e.getSource() == sugarButton) {
            productOutLabel.setIcon(sugarImg);
            makeCoffee("sugar");
            inMoney -= 200;
            money += 200;
        }else {
            productOutLabel.setIcon(blackImg);
            makeCoffee("black");
            inMoney -= 200;
            money += 200;
        }
        String inMoney_ =
                coinInputLabel.getText().substring(0,7)+inMoney+"원";
        coinInputLabel.setText(inMoney_);
        message.setText("총수입 : "+money+"원");
        processButton(inMoney);
    }

    private void makeCoffee(String coffee) {
        System.out.println(materials);
        if(coffee.equals("milk")){
            if(materials.isMakeMilkCoffee()) {
                materials.dispenseCoffee();
                materials.dispenseCream();
                materials.dispenseSugar();

                System.out.println(materials);
            }else {
                message.setText("밀크커피 재료부족합니다.!!");
                JOptionPane.showMessageDialog(null,"재료부족");
            }
        }else if(coffee.equals("sugar")){
            if(materials.isMakeSugarCoffee()) {
                materials.dispenseCoffee();
                materials.dispenseSugar();

                System.out.println(materials);
            }else {
                message.setText("설탕커피 재료부족합니다.!!");
                JOptionPane.showMessageDialog(null,"재료부족");
            }

        }else {
            if(materials.isMakeBlackCoffee()) {
                materials.dispenseCoffee();
                System.out.println(materials);
            }else {
                message.setText("밀크커피 재료부족합니다.!!");
                JOptionPane.showMessageDialog(null,"재료부족");
            }

        }
    }

    private void processButton(int inMoney) {

        milkButton.setEnabled(false);
        sugarButton.setEnabled(false);
        blackButton.setEnabled(false);

        if(inMoney >= 300) {
            if(materials.isMakeMilkCoffee() &&
                materials.isMakeSugarCoffee() &&
                materials.isMakeBlackCoffee()) {
                    milkButton.setEnabled(true);
                    sugarButton.setEnabled(true);
                    blackButton.setEnabled(true);
            }
        }

        if (inMoney >= 200){
            if(materials.isMakeSugarCoffee() &&
                    materials.isMakeBlackCoffee()){
                sugarButton.setEnabled(true);
                blackButton.setEnabled(true);
            }
        }

        // 재표체크
        if(!materials.isMakeMilkCoffee()){
            JOptionPane.showMessageDialog(null,"밀크커피 재료부족");
        }else if(!materials.isMakeSugarCoffee()){
            JOptionPane.showMessageDialog(null,"설탕커피 재료부족");
        }else if(!materials.isMakeBlackCoffee()){
            JOptionPane.showMessageDialog(null,"블랙커피 재료부족");
        }

    }

    public static void main(String[] args) {
        CoffeeVendingMachine vm = new CoffeeVendingMachine();
    }
}
