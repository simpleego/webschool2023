package com.simple.basiccomponent;

import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxPanel extends JPanel implements ItemListener {

    JCheckBox[] buttons = new JCheckBox[3];
    String[] fruits = {"apple","grape","orange"};
    JLabel[] pictureLabel = new JLabel[3];
    ImageIcon[] icons = new ImageIcon[3];

    public CheckBoxPanel(){
        super(new GridLayout(0,4));

        // 컴포넌트 생성
        for(int i=0; i<3; i++){
            buttons[i] = new JCheckBox(fruits[i]);
            buttons[i].addItemListener(this);
            pictureLabel[i] = new JLabel(fruits[i]+".gif");
            icons[i] = new ImageIcon(fruits[i]+".gif");
        }

        JPanel checkPanel = new JPanel(new GridLayout(0,1));
        for(int i=0; i<3; i++) {
            checkPanel.add(buttons[i]);
        }
        add(checkPanel);
        add(pictureLabel[0]);
        add(pictureLabel[1]);
        add(pictureLabel[2]);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        ImageIcon image = null;
        Object source = e.getItemSelectable();
        for(int i=0; i<3; i++){
            if(source == buttons[i]){
                if(e.getStateChange() == ItemEvent.DESELECTED){
                    pictureLabel[i].setIcon(null);
                }else {
                    pictureLabel[i].setIcon(icons[i]);
                }
            }
        }


    }
}
