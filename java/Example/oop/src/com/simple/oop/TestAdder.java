package com.simple.oop;

public class TestAdder {

    public static void main(String[] args) {

        Adder add = new Adder();
        int sum = add.add(10,20);
        System.out.println("결과값 : "+sum);

        sum = add.add("10","20");
        System.out.println("결과값 : "+sum);

        Divider div = new Divider();
        double result = div.divDouble(5,2);
        System.out.println("결과값 : "+result);
    }
}
