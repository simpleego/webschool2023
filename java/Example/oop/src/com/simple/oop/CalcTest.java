package com.simple.oop;

import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) {
        // 객체 생성 : 계산기 객체 생성
        Calculator cal = new Calculator();

        // 계산에 필요한 값을 키보드로 입력
        Scanner kbd = new Scanner(System.in);
        char menu=' ';
        char operator = ' ';

        do{
            System.out.println(" 1 : 숫자 입력");
            System.out.println(" 2 : 연산자 선택 : +,-,*,/, x(종료)");
            menu = kbd.nextLine().charAt(0);
            switch (menu){
                case '1':
                    // 숫자입력
                    String num1 = keyInput(1, kbd);
                    String num2 = keyInput(2, kbd);
                    cal.keyboardInput(num1,num2);
                    break;
                case '2':
                    System.out.println("연산자 선택 : +,-,*,/, x(종료)");
                    operator = kbd.nextLine().charAt(0);
                    if(operator == '+'){
                        cal.add();
                        System.out.println("결과값 : " +cal.getResult());
                    }
                    break;
                case 'x':
                    System.out.println("프로그램 종료합니다.");
                    break;
                default:
                    System.out.println("잘못입력하였습니다. ");
            }

        }while(operator != 'x');
    }

//    private static int keyInput(int no, Scanner kbd) {
//        System.out.print("숫자"+no+": ");
//        return Integer.parseInt(kbd.nextLine());
//    }
    private static String keyInput(int no, Scanner kbd) {
        System.out.print("숫자"+no+": ");
        return kbd.nextLine();
    }
}
