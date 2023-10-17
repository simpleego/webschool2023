package com.simple.classex;

public class RectangleTest {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(10,20);
        Rectangle r1 = new Rectangle(5,30);
        int area = r.calcArea();
        System.out.println("면적 :"+area);
        int area2 = r.calcArea(10,15);
        System.out.println("면적(평) :"+area2);
    }

}
