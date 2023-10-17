package com.simple.classex;

public class HandGame {
    public static void main(String[] args) {
        ComHand computer = new ComHand();
        UserHand userHand1 = new UserHand();
        // 가위, 바위, 보 시작
        userHand1.makeUserHand();
        String user = userHand1.showHand();
        String com = computer.showHand();

        System.out.println("컴퓨터 : "+com);
        System.out.println("나 : "+user);

        String result="";

        if(user.equals(com)){
            result = "무승부";
        }else if(com.equals("가위")){
            if(user.equals("보")){
                result="컴퓨터 승";
            }else {
                result="유저 승";
            }
        }else if(com.equals("바위")){
            if(user.equals("보")){
                result="유저 승";
            }else {
                result="컴퓨터 승";
            }
        }else if(com.equals("보")) {
            if (user.equals("가위")) {
                result = "유저 승";
            } else {
                result = "컴퓨터 승";
            }
        }
        System.out.println("판정결과 : " + result);

    }

}
