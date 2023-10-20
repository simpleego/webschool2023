public class ArraySearch {
    public static void main(String[] args) {
        // 배열: n개의 데이터를 저장
        // 참조방법: 인덱스를 이용하여 참조 ( s[2] )

        final int SIZE = 1000;

        int[] num = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            num[i] = (int)(Math.random()*100+1);
            System.out.println( i+1+" : "+num[i]);
        }

        int min;   // 최소값
        // n개 중에서 가장 작은 값을 찾으시오.

        // 1. 최소 최소값을 첫번째 값으로 설정
        min = num[0];

        for (int i = 0; i < 10; i++) {
          if(min > num[i]){
              // 최소값 갱신
              min = num[i];
          }
        }
        System.out.println("최소값 : "+min);
    }
}