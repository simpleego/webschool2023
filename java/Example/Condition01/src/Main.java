public class Main {
    public static void main(String[] args) {

        // 정수를 입력받아 짝수/홀수를 구분하여 출력
        // 입력은 int
        // 출력 String

        int num;
        //boolean even;
        String result;

        num = 0;
        // even = ;

        if((num%2) == 0){
            result ="짝수";
        }else {
            result ="홀수";
        }
        System.out.println("num : "+num);
        System.out.println("결과 : "+result);

    }
}