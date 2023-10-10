package com.simple.oop;

public class Calculator {
    int num1=0;
    int num2=0;

    double result;

    public void init(){
        num1 = 0;
        num2 = 0;
    }

    public double getResult() {
        return result;
    }

    public void keyboardInput(String num1, String num2){
        this.num1 = Integer.parseInt(num1);
        this.num2 = Integer.parseInt(num2);
    }
    public double add(){
        result = num1 + num2;
        return result;
    }
    public double sub(){
        result = num1 - num2;
        return result;
    }
    public double mul(){
        result = num1 * num2;
        return result;
    }
    public double div(){
        if(num2 != 0){
            result = (double) num1 / num2;
        }else {
            result = 0.0;
        }
        return result;
    }

}
