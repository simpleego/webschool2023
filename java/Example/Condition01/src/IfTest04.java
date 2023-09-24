public class IfTest04 {
    public static void main(String[] args) {
        // 학점계산
        // n개의 조건을 처리 : if()~ else if()~ else
        
        // 입력 : 점수
        // 출력 : 평점: A, B, C, D, F
        // 평점 기준 : A-> 90이상, 80>= B < 90
        int jumsu = 157;
        String grade = "";
        
        if(jumsu >= 90){
            grade = "A";
        }else if (jumsu >=80 ) {
            grade = "B";
        }else if (jumsu >=70 ) {
            grade = "C";
        }else if (jumsu >=60 ) {
            grade = "D";
        }else {
            grade = "F";
        }

        System.out.println("점수 : "+jumsu);
        System.out.println("등급 :"+grade);
    }
}
