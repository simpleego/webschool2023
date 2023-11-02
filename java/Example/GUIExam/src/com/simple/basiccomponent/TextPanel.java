package com.simple.basiccomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextPanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JTextArea textArea;

    public TextPanel(){
        super(new GridLayout(2,1));

        // 컴포넌트 생성
        textField = new JTextField(30);
        textField.addActionListener(this);

        textArea = new JTextArea(3,30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        textArea.setEditable(false);
        add(textField);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        textArea.append(text+"\n");
        textField.selectAll();
        //textArea.setCaretPosition(2);
    }

}
