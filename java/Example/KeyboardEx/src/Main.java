import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 키보드 입력 받기
        Scanner keyboard = new Scanner(System.in);
//      System.out.print("이름 입력 :");
        System.out.print("점수 입력 :");
        //String name = keyboard.nextLine();
        String jumsu_ = keyboard.nextLine();
        // 문자인지 숫자인지 체크
        // 숫자이면 정상처리
        // 문자이면 다시 입력
        int jumsu = Integer.parseInt(jumsu_)+100;
        //int jumsu = keyboard.nextInt();

        //System.out.println("입력한 이름:"+name);
        System.out.println("입력한 점수:"+jumsu);

    }
}