package com.simple.oop;

public class Adder {
    int num1;
    int num2;

    public int add(int num1, int num2){
        return num1+num2;
    }
    public int add(String num1, String num2){
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }
}
