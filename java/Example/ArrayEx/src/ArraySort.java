public class ArraySort {

    public static void main(String[] args) {
        // 배열 정렬
        // 정렬: 여러개의 값을 특정기준(key)으로 순서대로 나열(재배치)하는 것
        // 정렬방식 : 오름차순, 내림차순

        int[] num = new int[10];

        // 정수 데이터 10개 준비
        // 정수의 범위는 1~100
        for (int i = 0; i < num.length; i++) {
            num[i] = (int)(Math.random()*100)+1;
        }
        for (int x:num) {
            System.out.print(" "+x);
        }
        System.out.println();

        int a = 10;
        int b = 20;
        int c;

        //System.out.println("a: "+a+"b: "+b);
        // a와 b값을 변경
        /*c = a;
        a = b;
        b = c;*/
        int temp;
        //System.out.println("a: "+a+"b: "+b);

        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                if(num[i] > num[j]){
                    // 두개의 값을 교환
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
            for (int n : num ) System.out.print(" "+n);
            System.out.println();
        }








    }
}
