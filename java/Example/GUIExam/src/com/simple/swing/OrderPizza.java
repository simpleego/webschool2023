package com.simple.swing;

import javax.swing.*;
import java.awt.*;

public class OrderPizza extends JFrame {

    private int munuCombo;
    private int munuBulgoki;
    private int munuPotato;


    // 생성자로부터 가격을 받아서 설정;
    public OrderPizza(int munuCombo, int munuPotato, int munuBulgoki)  {

        // 멤버변수 초기화
        this.munuPotato = munuPotato;
        this.munuBulgoki = munuBulgoki;
        this.munuCombo = munuCombo;

        // 윈도우 생성에 필요한 설정
        setTitle("피자주문기");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());

        //  컴포넌트 생성
        JPanel panel = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();
        JPanel pricePanel = new JPanel();

        panel.setBackground(Color.gray);
        panelB.setBackground(Color.pink);

        JLabel label = new JLabel("자바 피자에 오신것을 환영합니다.");

        String comboPrice_= munuCombo+"원";
        JLabel comboPrice = new JLabel(comboPrice_);
        JLabel potatoPrice = new JLabel(munuPotato+"원");
        JLabel bulgokiPrice = new JLabel(munuBulgoki+"원");

        JButton button1 = new JButton("콤보피자");
        JButton button2 = new JButton("포테이토피자");
        JButton button3 = new JButton("불고기피자");

        // 컴포넌트 등록
        pricePanel.add(comboPrice);
        pricePanel.add(potatoPrice);
        pricePanel.add(bulgokiPrice);

        panelB.add(button1);
        panelB.add(button2);
        panelB.add(button3);

        panelA.add(label);

        //panel.add(panelA);
        // panel.add(panelB);

        this.add(panelA,BorderLayout.NORTH);
        this.add(panelB, BorderLayout.CENTER);
        this.add(pricePanel, BorderLayout.SOUTH);

        // 윈도우 활성화
        setVisible(true);
    }

    public static void main(String[] args) {
        new OrderPizza(10000,9000,20000);
    }
}