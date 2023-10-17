package com.simple.classex;

import java.util.Random;

public class ComHand {
    // 가위, 바위, 보
    private int hand;
    Random  rand = new Random();

    public ComHand() {
        hand = rand.nextInt(3);
    }

    private int getHand() {
        return hand;
    }
    public String showHand(){
        if(hand == 0){
            return "가위";
        }else if(hand == 1){
            return "바위";
        }else
            return "보";
    }

    public static void main(String[] args) {
        ComHand comHand = new ComHand();
        System.out.println(comHand.hand);
        String comHand_ = comHand.showHand();
        System.out.println("컴퓨터 : "+comHand_);
    }
}
