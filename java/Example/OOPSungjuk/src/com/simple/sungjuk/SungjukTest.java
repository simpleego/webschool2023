package com.simple.sungjuk;

public class SungjukTest {

    public static void main(String[] args) {

        Sungjuk sungjuk = new Sungjuk(10,20,30);
        System.out.println(sungjuk.toString());
        double avg = sungjuk.getAverage();
        int tot = sungjuk.getTot();
        System.out.println("총점:"+tot);
        System.out.println("평균:"+avg);
    }

}
