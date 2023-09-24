public class Calculator1 {


    public static void main(String[] args) {

        // 필요한 재료
        // 숫자가 데이터
        int num1, num2;
        double result;

        num1 = 7;
        num2 = 3;

        // 필요한 기능
        // 사칙연산,...
        result = num1 + num2;
        // 곧바로  결과 출력
        System.out.println("결과 : "+num1+" + "+num2+" = "+(int)result);

        result = num1 - num2;
        // 곧바로  결과 출력
        System.out.println("결과 : "+num1+" - "+num2+" = "+(int)result);

        result = num1 * num2;
        // 곧바로  결과 출력
        System.out.println("결과 : "+num1+" x "+num2+" = "+(int)result);

        result = (float)num1 / num2;
        // 곧바로  결과 출력
        System.out.println("결과 : "+num1+" / "+num2+" = "+result);

    }


}
