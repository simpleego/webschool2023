public class Main {
    public static void main(String[] args) {

        // 반복문 while : 조건에 따라 반복

        int i = 1;  // 반복제어용
        int sum=0;

        while(i <= 100){
            // sum = sum+i;
            sum += i;  // 누적공식
            System.out.println("중간 합 : "+sum);
            i++;        // couter 공식
        }
        System.out.println("최종합 :"+sum);
    }
}