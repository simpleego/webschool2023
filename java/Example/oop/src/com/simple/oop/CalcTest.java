package com.simple.oop;

import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) {
        // 객체 생성 : 계산기 객체 생성
        Calculator cal = new Calculator();

        // 계산에 필요한 값을 키보드로 입력
        Scanner kbd = new Scanner(System.in);
        char menu=' ';

        do{
            System.out.println(" 숫자 입력 : 1");
            System.out.println(" 연산자 선택 : 덧셈(+), 뺄셈(-),곱셈(*),나눗셈(/),종료(x)");
            menu = kbd.nextLine().charAt(0);
            switch (menu){
                case '1':
                    // 숫자입력
                    String num1 = keyInput(1, kbd);
                    String num2 = keyInput(2, kbd);
                    cal.keyboardInput(num1,num2);
                    break;
                case '+':
                    cal.add();
                    System.out.println(cal.num1+"+"+ cal.num2+"="+cal.getResult());
                    break;
                case '-':
                    cal.sub();
                    System.out.println(cal.num1+"-"+ cal.num2+"="+cal.getResult());
                    break;
                case '*':
                    cal.mul();
                    System.out.println(cal.num1+"x"+ cal.num2+"="+cal.getResult());
                    break;
                case '/':
                    cal.div();
                    System.out.println(cal.num1+"/"+ cal.num2+"="+cal.getResult());
                    break;
                case 'x':
                    System.out.println("프로그램을 종료합니다!!");
                    break;
                default:
                    System.out.println("잘못입력하였습니다. ");
            }
        }while(menu != 'x');
    }

    private static String keyInput(int no, Scanner kbd) {
        System.out.print("숫자"+no+": ");
        return kbd.nextLine();
    }
}
