package com.simple.collection;

import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        list.add("우유");
        list.add("빵");
        list.add("사과");
        System.out.println("배열크기 :"+list.size());
        System.out.println(list);
        list.add(1,"오렌지");
        System.out.println(list);
        System.out.println("배열크기 :"+list.size());
        list.set(2,"포도");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println("배열크기 :"+list.size());
        System.out.print("[");
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+",");
        }
        System.out.print("]");

        for (String item: list) {
            System.out.println(" "+item);
        }

        // 반복자를 이용한 list출력
        Iterator e = list.iterator();
        String item;
        while (e.hasNext()){
            item = (String) e.next();
            System.out.print(" "+item);
        }

        String[] name={"홍길동","강감찬","이순신"};
        List<String> list2 = Arrays.asList(name);
        System.out.println(list2);
    }

}
