package com.simple.oop2;

public class Constructor {
    String name;
    int age;
    String addr;

    public Constructor(){

    }
    public Constructor(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public Constructor(String name, String addr) {
        this.name = name;
        this.age = 20;
        this.addr = addr;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public static void main(String[] args) {
        Constructor obj = new Constructor("홍길동",25,"서울시");
        Constructor obj1 = new Constructor();

        int age = obj.getAge();
        String name = obj.getName();
        System.out.println("이름:"+name);
        System.out.println("나이:"+age);
        obj.setName("홍길동");
        obj.setAge(25);

    }
}
