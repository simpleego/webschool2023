package com.simple.sungjuk;

import java.util.Scanner;

public class ArraySungjuk {

    public static void main(String[] args) {

        System.out.println("데이터의 갯수는 ?");
        Scanner kbd = new Scanner(System.in);

        int size = kbd.nextInt();

        // 요청한 크기만큼 배열을 준비
        String [][] jumsu = new String[size][4];

        jumsu[0][0] = "홍길동";
        jumsu[0][1] = "80";
        jumsu[0][2] = "75";
        jumsu[0][3] = "90";

        jumsu[1][0] = "김남길";
        jumsu[1][1] = "60";
        jumsu[1][2] = "20";
        jumsu[1][3] = "50";

        jumsu[2][0] = "최유화";
        jumsu[2][1] = "45";
        jumsu[2][2] = "88";
        jumsu[2][3] = "99";

        for (int i=0; i<size; i++){
            for (int j=0; j<4; j++){
                System.out.print(jumsu[i][j]+" ");
            }
            System.out.println();
            //System.out.printf("\n");
        }

        // 총점을 구하여 출력하세요
        // 정수변환-> 총점, 평균 구하여 출력
        int total=0;
        double avg=0.0;

        // 모든 과목의 총점과 평균을 출력
        // 과목별 총점 변수
        int[] totals  =  new int[3];
        String[] totals_ = {"국어평균","영어평균","수학평균"};

        for (int i=0; i<size; i++){
            for (int j=1; j<4; j++){
                totals[j-1] += Integer.parseInt(jumsu[i][j]);
            }
        }

        for (int i=0; i<3; i++){
            System.out.printf("%s ",totals_[i]);
            System.out.printf("%.2f  ",(double) totals[i]/size);
        }

        /*
        System.out.print("국어총점 : " + korTot);
        System.out.printf("국어평균 : %.2f \n",(double)korTot/size);

        System.out.print("영어총점 : " + engTot);
        System.out.printf("영어평균 : %.2f\n",(double)engTot/size);

        System.out.print("수학총점 : " + matTot);
        System.out.printf("수학평균 : %.2f",(double)matTot/size);
        */

    }
}
