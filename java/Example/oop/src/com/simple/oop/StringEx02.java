package com.simple.oop;

import java.time.LocalDateTime;

public class StringEx02 {

    public static void main(String[] args) {
        // 주민번호 정보를 이용하여 성별과 나이를 출력하시오.
        // 020625-4403619
        // 680303-1449622
        // 주민번호 앞에 2자리는 태어난 년도, 8번째 한 자리는 성별
        //String code = "020625-4403619";

        String code = "010-2533-0129";
        String year_ = code.substring(0,2);
        LocalDateTime now = LocalDateTime.now();
        String []codes = code.split("-");

        System.out.println("code : "+codes[0]);
        System.out.println("code : "+codes[1]);
        System.out.println("code : "+codes[2]);

        for (String code1 : codes){
            System.out.println("code : "+code1);
        }

        int currentYear = now.getYear();
        int age=0;
        String gender="";

        char gender_ = code.charAt(7);
        System.out.println(year_);
        System.out.println(gender_);

        switch (gender_){
            case '1':
                gender="남";
                age = currentYear - (Integer.parseInt(year_)+1900);
                break;
            case '2':
                gender="여";
                age = currentYear - (Integer.parseInt(year_)+1900);
                break;
            case '3':
                gender="남";
                age = currentYear - (Integer.parseInt(year_)+2000);
                break;
            case '4':
                gender="여";
                age = currentYear - (Integer.parseInt(year_)+2000);
                break;
            default:
                System.out.println("코드 에러");
        }
        System.out.println("성별 :"+gender);
        System.out.println("나이 :"+age);

    }
}
