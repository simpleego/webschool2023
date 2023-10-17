package com.simple.classex;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(int width) {
        this(100,width);
    }

    public int calcArea(){
        return width*length;
    }
    public int calcArea(int width, int height){
        return (int) ((width*height)/3.3);
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }



    // 기능(서비스)

}
