package com.simple.oop;

public class MethodOverloading {

    public int add(int num1, int num2){
        return num1+num2;
    }

    public double add(double num1, double num2){
        return num1+num2;
    }

    public String add(String num1, String num2){
        return num1+"+"+num2;
    }
}
