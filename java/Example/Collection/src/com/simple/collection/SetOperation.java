package com.simple.collection;

import java.util.HashSet;
import java.util.Set;

public class SetOperation {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> union = new HashSet<>();
        Set<String> intersection = new HashSet<>();
        Set<String> diff = new HashSet<>();

        s1.add("A");
        s1.add("B");
        s1.add("C");

        s2.add("A");
        s2.add("D");
        union = new HashSet<>(s1);
        union.addAll(s2);
        intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        diff = new HashSet<>(s1);
        diff.removeAll(s2);

        System.out.println("합집합: "+union);
        System.out.println("교집합: "+intersection);
        System.out.println("차집합: "+diff);
    }
}
