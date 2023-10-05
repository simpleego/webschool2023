import java.util.Scanner;

public class Sungjuk01 {
    public static void main(String[] args) {
        // 입력: 이름, 성별, 학번, 국어, 영어, 수학
        String name;
        boolean gender;
        String code;
        int kor,eng,mat;
        int total;
        double avg, korAvg, engAvg, matAvg;
        final int SUBJECT_COUNT = 3;

        Scanner kbd = new Scanner(System.in);
        System.out.println("--------- 성적표 ---------");
        System.out.println("이름 성별 학번 국어  영어  수학  총점  평균");

        System.out.print("이름 :");
        name = kbd.nextLine();

        System.out.print("성별 :");
        String gender_ = kbd.nextLine();

        System.out.print("학번 :");
        code = kbd.nextLine();

        System.out.print("국어 :");
        kor = Integer.parseInt(kbd.nextLine());

        System.out.print("영어 :");
        eng = Integer.parseInt(kbd.nextLine());

        System.out.print("수학 :");
        mat = Integer.parseInt(kbd.nextLine());

        // 처리: 총점, 평균, 과목별 평균
        // 총점=국어+영어+수학
        // 평균=총점/과목수
        total = kor + eng + mat;
        avg = (double) total / SUBJECT_COUNT;

        // 출력
        System.out.printf("%s %s %s %4d %4d %4d %4d %6.2f\n",
                name,gender_,code,kor,eng,mat,total,avg);

    }
}