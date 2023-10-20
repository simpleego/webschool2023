public class Main {
    public static void main(String[] args) {
        // 배열: n개의 데이터를 저장
        // 참조방법: 인덱스를 이용하여 참조 ( s[2] )

        final int SIZE = 10;

        int[] num = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            num[i] = (int)(Math.random()*100);
            System.out.println( i+1+" : "+num[i]);
        }

        int total = 0;
        double average;

        // n개의 평균을 구하시오.
        for (int i = 0; i < 10; i++) {
           // 평균 구하기
           // n개의 값을 더하기
            total += num[i];
        }
        // 총합을 n개로 나누어 평균구하기
        average = (double) total / SIZE;

        System.out.printf("평균 : %10.3f",average);


    }
}