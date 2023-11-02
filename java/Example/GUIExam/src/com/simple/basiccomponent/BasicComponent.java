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
    private RadioButtonPanel radioButtonPanel;
    private TextPanel textPanel;
    private ComboBoxPanel comboBoxPanel;

    public BasicComponent() {
        setTitle("윈도우 기본 컴포넌트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,480);

        // 컴포넌트 생성
        checkBoxPanel = new CheckBoxPanel();
        radioButtonPanel = new RadioButtonPanel();
        textPanel = new TextPanel();
        comboBoxPanel = new ComboBoxPanel();

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
        add(radioButtonPanel,BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(textPanel,BorderLayout.EAST);
        add(comboBoxPanel, BorderLayout.WEST);

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
