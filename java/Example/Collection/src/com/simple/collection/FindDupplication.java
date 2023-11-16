package com.simple.collection;

import java.util.HashSet;
import java.util.Set;

public class FindDupplication {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        String[] sample={"단어","중복","구절","중복","단어"};
        for(String a: sample){
            if(!s.add(a)){
                System.out.println("중복 단어:"+a);
            }
        }
        System.out.println(s.size()+"중복되지 않은 단어:"+s);
    }
}
