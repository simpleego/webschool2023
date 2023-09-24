public class CalculatorMethod1 {


    public static void main(String[] args) {

        // 필요한 재료
        // 숫자가 데이터
        int num1, num2;

        num1 = 7;
        num2 = 3;

        // 필요한 기능
        // 사칙연산,...
        calc(num1, num2);
        System.out.println("sum :"+adder(10,20));
   }

    private static void calc(int num1, int num2) {
        int add;
        int sub;
        int mul;
        float div;

        add = adder(num1,num2); // num1 + num2;
        sub = subtractor(num1,num2); //num1 - num2;
        mul = multipler(num1,num2); //num1 * num2;
        div = divider(num1,num2); // (float)num1 / num2;

        System.out.println("결과 : "+num1+" + "+num2+" = "+add);
        System.out.println("결과 : "+num1+" - "+num2+" = "+sub);
        System.out.println("결과 : "+num1+" x "+num2+" = "+mul);
        System.out.println("결과 : "+num1+" / "+num2+" = "+div);
    }

    private static int adder(int num1, int num2) {
        int result = num1+num2;
        return result;
    }
    private static int subtractor(int num1, int num2) {
        int result = num1-num2;
        return result;
    }
    private static int multipler(int num1, int num2) {
        int result = num1*num2;
        return result;
    }
    private static float divider(int num1, int num2) {
        float result = num1/(float)num2;
        return result;
    }


}
