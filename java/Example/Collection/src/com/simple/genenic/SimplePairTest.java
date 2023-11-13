package com.simple.genenic;

public class SimplePairTest {

    public static void main(String[] args) {
        SimplePair<String, Integer> pair = new SimplePair<>("apple", 10);
        String data = pair.getData1();
        System.out.println(data);

        pair.setFirst("오렌지");
        System.out.println(pair.getData1());

        SimplePair<Integer,Double> ipair = new SimplePair<>(10, 20.5);
        System.out.println(ipair.getData1()+ipair.getData2());

    }
}
