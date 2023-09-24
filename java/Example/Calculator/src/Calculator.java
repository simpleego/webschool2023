public class Calculator {


    public static void main(String[] args) {

        // 필요한 재료
        // 숫자가 데이터
        int num1, num2;
        int add;
        int sub;
        int mul;
        double div;

        num1 = 7;
        num2 = 3;

        // 필요한 기능
        // 사칙연산,...
        add = num1 + num2;
        sub = num1 - num2;
        mul = num1 * num2;
        div = (float)num1 / num2;

        // 사칙연산 결과 출력
        // 결과 : 10 + 20 = 30
        System.out.println("결과 : "+num1+" + "+num2+" = "+add);
        System.out.println("결과 : "+num1+" - "+num2+" = "+sub);
        System.out.println("결과 : "+num1+" x "+num2+" = "+mul);
        System.out.println("결과 : "+num1+" / "+num2+" = "+div);
//        System.out.println(" 계산 결과");
//        System.out.println("숫자1: "+num1);
//        System.out.println("숫자2: "+num2);
//        System.out.println("덧셈결과: "+result);
    }


}
