import java.util.Scanner;

public class Adder {

    public static void main(String[] args) {
        // 키보드로 숫자를 입력받아
        // 두 수의 덧셈 결과를 구한다.
        // 10,20 -> 30
        // int num1=10;
        long num1, num2;
        long result;

        // 키보드 입력 담당 객체 생성
        Scanner input = new Scanner(System.in);
        System.out.print("첫번째 수 :");
        String num1_ = input.nextLine();
        // 100->494848--> 메모리-->"100"-->100

        System.out.print("두번째 수 :");
        String num2_ = input.nextLine();

        // 키보드 입력값을 출력
        System.out.println("숫자1 :"+num1_);
        System.out.println("숫자2 :"+num2_);

        // 문자열을 숫자로 변환
//        num1 = Integer.parseInt(num1_);
//        num2 = Integer.parseInt(num2_);
        num1 = Long.parseLong(num1_);
        num2 = Long.parseLong(num2_);

        result = num1 + num2;
        System.out.println(num1+"+"+num2+"="+result);

    }
}
