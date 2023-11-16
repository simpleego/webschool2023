package com.simple.collection;

import java.util.*;

public class SetEx {
    public static void main(String[] args) {
        //HashSet<String> list = new HashSet<>();
        LinkedHashSet<String> list = new LinkedHashSet<>();
        list.add("우유");
        list.add("빵");
        list.add("빵");
        list.add("사과");
        list.add("버터");
        list.add("버터");
        list.add("햄");
        System.out.println("배열크기 :"+list.size());
        System.out.println(list);

    }

}
