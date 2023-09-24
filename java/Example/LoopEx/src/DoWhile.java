import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {

        // 입력변수
        int month;
        String input="";

        // 처리할 내용
        // 정확한 월을 입력하였는지 비교
        // 정확한 월을 입력할때까지 반복 처리
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.print("월을 입력(1~12) : ");
            input = kbd.nextLine();
            month = Integer.parseInt(input);
        }while( !(month >=1 && month <=12));  //while (month <1 || month > 12);

        // 출력
        // 사용자가 입력한 월을 출력
        System.out.println("입력한 월은 "+month);
    }
}
