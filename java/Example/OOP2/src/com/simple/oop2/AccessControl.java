package com.simple.oop2;

public class AccessControl {
    private String name="홍길동";
    private int age = 25;
    private String addr = "서구 둔산동 123";

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    private String getAddr() {
        return "대전시 "+addr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age<0 || age > 100) return;
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void showInfo(){
        System.out.println("이름 :" +getName());
        System.out.println("나이 :" +getAge());
        System.out.println("주소 :" +getAddr());
    }
}
