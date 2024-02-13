package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class HelloLombok {
    private final String hello;
    private  final int lombok;

//    public HelloLombok(String hello, int lombok) {
//        this.hello = hello;
//        this.lombok = lombok;
//    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("안녕",10);
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

        //helloLombok.setHello("안녕123");
        //helloLombok.setLombok(55);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }
}
