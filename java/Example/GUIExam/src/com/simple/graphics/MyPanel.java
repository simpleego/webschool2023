package com.simple.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class MyPanel extends JPanel {

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MyPanel() {

       setBorder(BorderFactory.createLineBorder(Color.RED));

       addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               super.mouseDragged(e);
           }

           @Override
           public void mouseMoved(MouseEvent e) {
               super.mouseMoved(e);
               moveSquare(e.getX(), e.getY());
           }
       });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                moveSquare(e.getX()+200, e.getY()+200);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
    private void moveSquare(int x, int y){
        int OFFSET = 1;
        if((squareX != x) || (squareY != y)) {
            repaint(squareX,squareY,
                    squareW+OFFSET, squareH+OFFSET);
            squareX = x;
            squareY = y;
            repaint(squareX,squareY,
                    squareW+OFFSET, squareH+OFFSET);
        }

    }

    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        System.out.println("===>");
        g.setColor(Color.red);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.black);
        g.drawRect(squareX, squareY,squareW,squareH);
    }
}
