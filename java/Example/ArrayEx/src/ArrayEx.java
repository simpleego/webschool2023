public class ArrayEx {
    public static void main(String[] args) {
        // 배열: n개의 데이터를 저장
        // 참조방법: 인덱스를 이용하여 참조 ( s[2] )

        final int SIZE = 20;

        int[] num = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            num[i] = (int)(Math.random()*6+2);
            System.out.print( i+1+":"+num[i]+",");
        }

        int searchKey = 3;
        boolean search=false;

        // searchKey를 모두 찾으시오.
        for (int i = 0; i < 10; i++) {
           // 특정한 값을 검색하기
            if(searchKey == num[i]){
                System.out.println("찾았다 "+"위치"+i+"번째");
                search = true;
                break;
            }
        }
        if(!search) {
            System.out.println("값을 찾을 수 없습니다.");
        }
    }
}