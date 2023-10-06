import java.util.Scanner;

public class SungjukArray01 {

    final static int SUBJECT_COUNT = 3;

    public static void main(String[] args) {
        // 입력: 이름, 성별, 학번, 국어, 영어, 수학
        String name;
        boolean gender=false;
        String gender_="여";

        String code;
        int kor,eng,mat;
        int korSum=0, engSum=0, matSum=0;
        int count=0;
        int total;
        double avg, korAvg, engAvg, matAvg;
        char grade;

        Scanner kbd = new Scanner(System.in);
        System.out.println("--------- 성적표 ---------");
        System.out.println("이름 성별 학번 국어  영어  수학  총점  평균");

        for (int i=0; i<3; i++){
            System.out.print("이름 :");
            name = kbd.nextLine();

            System.out.print("성별 : 남(m) 여(f):");
            gender_ = kbd.nextLine();

            if(gender_.equals("m")){
                gender = true;
                gender_ = "남";
            }else {
                gender = false;
                gender_ = "여";
            }

            System.out.print("학번 :");
            code = kbd.nextLine();

            System.out.print("국어 :");
            kor = Integer.parseInt(kbd.nextLine());

            System.out.print("영어 :");
            eng = Integer.parseInt(kbd.nextLine());

            System.out.print("수학 :");
            mat = Integer.parseInt(kbd.nextLine());

            // 처리: 총점, 평균, 학점, 과목별 평균
            // 총점=국어+영어+수학
            // 평균=총점/과목수
            // total = kor + eng + mat;
            // grade = A, B, C, D, F
            // 과목별 평균 = 과목총점(korSum) / 데이터 수(count)
            total = getTotal(kor,eng,mat);
            avg = getAvg(total); // (double) total / SUBJECT_COUNT;
            grade = getGrade(avg);

            // 과목별 총점
            korSum += kor;
            engSum += eng;
            matSum += mat;

            count++;

            // 출력
            System.out.printf("%s %s %s %4d %4d %4d %4d %6.2f %c\n",
                    name,gender_,code,kor,eng,mat,total,avg, grade);
        }

        korAvg = (double) korSum / count;
        engAvg = (double) engSum / count;
        matAvg = (double) matSum / count;

        System.out.println("--- 과목별 평균 ---");
        System.out.printf("국어평균 : %6.2f", korAvg);
        System.out.printf("영어평균 : %6.2f", engAvg);
        System.out.printf("수학평균 : %6.2f", matAvg);
    }

    private static int getTotal(int kor, int eng, int mat) {
        //int total = kor + eng + mat;
        return kor + eng + mat;
    }

    private static double getAvg(int tot){
        return (double) tot / SUBJECT_COUNT;
    }

    private static char getGrade(double avg) {
        char grade='F';

        if(avg >= 90.0){
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        }else if (avg >= 70) {
            grade = 'C';
        }else if (avg >= 60) {
            grade = 'D';
        }
        return grade;
    }
}