package com.simple.collection;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("우유");
        list.add("빵");
        list.add("사과");
        System.out.println(list);
        list.add(1,"오렌지");
        System.out.println(list);
        list.set(2,"포도");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list);
    }

}
