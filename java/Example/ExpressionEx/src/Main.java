public class Main {
    public static void main(String[] args) {
       int num = 55;
       int result;
       boolean even = true;
       // 홀수 짝수 구분

        result = num % 2;
        even = result != 0;
        System.out.println("나머지 : "+result);
        System.out.println("짝수인가 : "+even);
    }
}