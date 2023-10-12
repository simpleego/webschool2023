package com.simple.sungkuk;

import java.util.Calendar;
import java.util.Scanner;

public class SungjukFinal {

    public static void main(String[] args) {

        final int COL = 9;
        final int SUBJECT_COL = 3;
        final int SUBJECT_COUNT = 3;
        int size = 0;

        int countMale=0;
        int countFemale=0;

        int[] totals = new int[3];
        int[][] totalsGender = new int[2][3];
        String[] totals_ = {"국어", "영어", "수학"};

        do {
            System.out.println("데이터의 갯수는 (3~50) ?");
            Scanner kbd = new Scanner(System.in);

            size = kbd.nextInt();
            if (size < 3 || size > 50) {
                System.out.println("데이터 갯수 오류입니다. \n 다시입력하세요.");
            }

        } while (size < 3 || size > 50);


        // 요청한 크기만큼 배열을 준비
        String[][] jumsu = new String[size][COL];

        String[] gender = {"남", "여"};
        String[] firstName = {"김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "유", "고", "문", "양", "손"};
        String[] name = {"수빈", "영희", "철수", "영수", "진희", "동철", "효순", "동건", "나영"};
        String[] dept = {"컴퓨터공학", "수학", "영문학", "기계공학", "법학", "생물학"};
        String[] deptCode = {"01", "02", "03", "04", "05", "06"};

        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < size; i++) {
            // 난수 변수 준비
            int genderSelection = (int) (Math.random() * gender.length);
            int firstSelection = (int) (Math.random() * firstName.length);
            int nameSelection = (int) (Math.random() * name.length);
            int deptSelection = (int) (Math.random() * dept.length);

            jumsu[i][0] = firstName[firstSelection] + name[nameSelection];
            jumsu[i][1] = gender[genderSelection];
            jumsu[i][2] = cal.get(Calendar.YEAR) + deptCode[deptSelection] + (i + 1);
            jumsu[i][3] = String.valueOf((int) (Math.random() * 71 + 30));
            jumsu[i][4] = String.valueOf((int) (Math.random() * 71 + 30));
            jumsu[i][5] = String.valueOf((int) (Math.random() * 71 + 30));
        }

        int count = 0;


        // 총점을 구하여 출력하세요
        // 정수변환-> 총점, 평균 구하여 출력
        int total = 0;
        double avg = 0.0;

        // 모든 과목의 총점과 평균을 출력
        // 과목별 총점 변수

        for (int i = 0; i < size; i++) {

            // 남/녀별 인원수
            if(jumsu[i][1].equals("남")){
                countMale++;
            }else {
                countFemale++;
            }
            int tot = 0;
            int endCol = SUBJECT_COL+SUBJECT_COUNT;
            for (int j = SUBJECT_COL; j < endCol; j++) {
                tot += Integer.parseInt(jumsu[i][j]);
                totals[j - SUBJECT_COL] += Integer.parseInt(jumsu[i][j]);
                // 남/녀별 과목총점
                if(jumsu[i][1].equals("남")){
                    totalsGender[0][j - SUBJECT_COL] += Integer.parseInt(jumsu[i][j]);
                }else {
                    totalsGender[1][j - SUBJECT_COL] += Integer.parseInt(jumsu[i][j]);
                }
            }
            double average = tot / SUBJECT_COUNT;
            jumsu[i][SUBJECT_COL+SUBJECT_COUNT] = String.valueOf(tot);
            jumsu[i][SUBJECT_COL+SUBJECT_COUNT+1] = String.valueOf(average);
            jumsu[i][SUBJECT_COL+SUBJECT_COUNT+2] = getGrade(average);
        }

        //  기본성적표 출력
        for (int i = 0; i < size; i++) {
            System.out.printf("%-3d", ++count);
            for (int j = 0; j < COL; j++) {
                System.out.printf("%-4s ",jumsu[i][j]);
            }
            System.out.println();
            if ((i + 1) % 5 == 0) {
                System.out.println("----------------------------------------------------");
            }
            //System.out.printf("\n");
        }

        System.out.println();
        System.out.println(">>> 과목별 평균 <<<");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s평균 : ", totals_[i]);
            System.out.printf("%.2f  \n", (double) totals[i] / size);
        }

        System.out.println();
        System.out.println(">>>   남/녀별 인원수  <<<");
        System.out.printf("남자 : %3d \n", countMale);
        System.out.printf("여자 : %3d  \n", countFemale);
        System.out.println();

        System.out.println(">>>  남녀/과목별 평균  <<<");
        System.out.printf("       --- %s ---  %s --- \n","남자","여자");

        for (int i = 0; i < 3; i++) {
            //System.out.printf("%6.2f : ", (double)totalsGender[0][i]/countMale);
            System.out.printf("%s평균 : %6.2f | %6.2f \n",
                    totals_[i] , (double)totalsGender[0][i] / countMale,
                    (double)totalsGender[1][i] / countFemale);
        }
    }

    private static String getGrade(double average) {
        char grade='F';

        if(average >= 90.0){
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        }else if (average >= 70) {
            grade = 'C';
        }else if (average >= 60) {
            grade = 'D';
        }
        return String.valueOf(grade);
    }

}
