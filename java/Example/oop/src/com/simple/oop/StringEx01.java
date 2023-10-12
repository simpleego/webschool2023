package com.simple.oop;

public class StringEx01 {

    public static void main(String[] args) {
        String name1="홍길동";
        String name2="홍길동";
        String name3="홍길동";

        System.out.println(name1.hashCode());
        System.out.println(name2.hashCode());
        System.out.println(name3.hashCode());

        String 이름1 = new String("이순신");
        String 이름2 = new String("이순신");
        String 이름3 = new String("이순신");
        System.out.println(이름1.hashCode());
        System.out.println(이름2.hashCode());
        System.out.println(이름3.hashCode());
        이름3="안녕";
        System.out.println(이름3.hashCode());
    }
}
