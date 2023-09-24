public class IfTest04_01 {
    public static void main(String[] args) {
        // 학점계산
        // n개의 조건을 처리 : if()~ else if()~ else
        
        // 입력 : 점수
        // 출력 : 평점: A, B, C, D, F
        // 평점 기준 : A-> 90이상, 80>= B < 90
        int jumsu = 87;
        String grade = "";
        
        if(jumsu >= 90){
            grade = "A";
        }
        if (jumsu < 90){
            if(jumsu >=80){
                grade = "B";
            }
        }

        if (jumsu < 80 && jumsu >=70 ) {
            grade = "C";
        }

        if (jumsu < 70 && jumsu >=60 ) {
            grade = "D";
        }

        if(jumsu < 60) {
            grade = "F";
        }

        System.out.println("점수 : "+jumsu);
        System.out.println("등급 :"+grade);
    }
}
