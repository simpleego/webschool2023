package com.simple.basiccomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxPanel extends JPanel implements ActionListener {

    JComboBox comboBox;
    String[] fruits = {"apple","grape","orange"};
    JLabel[] pictureLabel = new JLabel[3];
    ImageIcon[] icons = new ImageIcon[3];

    public ComboBoxPanel(){
        super(new GridLayout(0,1));

        for(int i=0; i<3; i++){
            pictureLabel[i] = new JLabel(fruits[i]+".gif");
            icons[i] = new ImageIcon(fruits[i]+".gif");
        }

        // 컴포넌트 생성
        comboBox = new JComboBox(fruits);
        comboBox.addActionListener(this);
        comboBox.setSelectedIndex(0);

        add(comboBox);
        add(pictureLabel[0]);
        add(pictureLabel[1]);
        add(pictureLabel[2]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String name = (String) cb.getSelectedItem();
        changePicture(name);
    }

    protected void changePicture(String name) {
        ImageIcon icon = new ImageIcon(name + ".gif");

        // 모든 선택 초기화
        for(int i=0; i<3; i++) {
            pictureLabel[i].setIcon(null);
        }

        if(name.equals("apple")){
            pictureLabel[0].setIcon(icon);
        }else if(name.equals("orange")){
            pictureLabel[1].setIcon(icon);
        }else {
            pictureLabel[2].setIcon(icon);
        }

    }

}
