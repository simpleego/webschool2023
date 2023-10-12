package com.simple.oop;

public class MethodOverTest {

    public static void main(String[] args) {
        // 객체생성
        MethodOverloading cal = new MethodOverloading();

        int result = cal.add(10,20);
        System.out.println("덧셈결과 :"+result);

        double result1 = cal.add(10.5,20.4);
        System.out.println("덧셈결과 :"+result1);

        String result2 = cal.add("10.5","20.4");
        System.out.println("덧셈결과 :"+result2);

        // 객체 테스트
    }
}
