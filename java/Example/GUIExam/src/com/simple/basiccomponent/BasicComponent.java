package com.simple.basiccomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicComponent extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel label;
    private JButton button;
    private CheckBoxPanel checkBoxPanel;

    public BasicComponent() {
        setTitle("윈도우 기본 컴포넌트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,480);

        // 컴포넌트 생성
        checkBoxPanel = new CheckBoxPanel();
        panel = new JPanel();
        label = new JLabel("이미지를 보려면 아래 버튼을 눌러봐");

        button = new JButton("^^");
        ImageIcon icon = new ImageIcon("icon.gif");
        button.addActionListener(this);
        button.setIcon(icon);

        // 컴포넌트 등록
        panel.add(label);
        panel.add(button);

        add(checkBoxPanel,BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ImageIcon dog = new ImageIcon("src/dog1.gif");
        label.setIcon(dog);

    }
    public static void main(String[] args) {
        new BasicComponent();
    }
}
