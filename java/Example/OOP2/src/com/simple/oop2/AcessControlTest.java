package com.simple.oop2;

public class AcessControlTest {

    public static void main(String[] args) {

        AccessControl obj = new AccessControl();
        obj.showInfo();
        obj.setName("홍길순");
        obj.showInfo();
        int age = obj.getAge();
        obj.setAge(200);
        System.out.println("나이:"+obj.getAge());

    }
}
