package com.simple.oop;

public class StringEx {

    public static void main(String[] args) {
        char []names = {'H','e','l','l','o',' ', 'J','a','v','a'};
        String str = null;
        String str2 = null;

        System.out.println(names[0]);
        System.out.println(names);
        System.out.println(names.length);

        String name = "Hello Java";
        System.out.println(name.charAt(0));
        System.out.println(name);
        System.out.println(name.length());
        str = name;
        System.out.println("str : "+str);
        str = str + "_홍길동";

        System.out.println("str : "+str);
        System.out.println("name : "+name);

        String name2 = new String("Hello Java");
        System.out.println(name2);
        System.out.println(name2.hashCode());

        str2 = name2;
        System.out.println(str2.hashCode());
        System.out.println("str2 : "+str2);
        name2 = "Hello World";
        str2 = str2 + "_이순신";
        System.out.println(str2.hashCode());

        System.out.println("str2 : "+str2);
        System.out.println("name2 : "+name2);
    }
}
