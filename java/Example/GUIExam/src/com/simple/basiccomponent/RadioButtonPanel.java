package com.simple.basiccomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonPanel extends JPanel implements ActionListener {

    JRadioButton[] buttons = new JRadioButton[3];
    String[] fruits = {"apple","grape","orange"};
    JLabel[] pictureLabel = new JLabel[3];
    ImageIcon[] icons = new ImageIcon[3];

    public RadioButtonPanel(){
        super(new GridLayout(0,4));

        ButtonGroup size = new ButtonGroup();

        // 컴포넌트 생성
        for(int i=0; i<3; i++){
            buttons[i] = new JRadioButton(fruits[i]);
            buttons[i].addActionListener(this);
            pictureLabel[i] = new JLabel(fruits[i]+".gif");
            icons[i] = new ImageIcon(fruits[i]+".gif");
            size.add(buttons[i]);
        }

        JPanel radioPanel = new JPanel(new GridLayout(0,1));
        for(int i=0; i<3; i++) {
            radioPanel.add(buttons[i]);
        }
        add(radioPanel);
        add(pictureLabel[0]);
        add(pictureLabel[1]);
        add(pictureLabel[2]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 모든 선택 초기화
        for(int i=0; i<3; i++) {
            pictureLabel[i].setIcon(null);
        }

        if(e.getSource() == buttons[0]){
           pictureLabel[0].setIcon(icons[0]);
        }else if(e.getSource() == buttons[1]) {
            pictureLabel[1].setIcon(icons[1]);
        }else{
            pictureLabel[2].setIcon(icons[2]);
        }
    }
}
