package com.simple.classex;

import java.util.Scanner;

public class UserHand {
    private int userHand;
    Scanner kbd = new Scanner(System.in);

    public UserHand() {
        userHand = 1;
    }

    public UserHand(int userHand) {
        this.userHand = userHand;
    }

    public void makeUserHand(){
        System.out.println(" 가위: 0, 바위: 1, 보:2" );
        userHand = Integer.parseInt(kbd.nextLine());
    }

    public String showHand(){
        String[] hands = {"가위","바위","보"};
        return hands[userHand];
    }

    public static void main(String[] args) {
        ComHand computer = new ComHand();
        computer.showHand();

        UserHand userHand1 = new UserHand();
        System.out.println(userHand1.showHand());
        userHand1.makeUserHand();
        System.out.println(userHand1.showHand());
    }
}
