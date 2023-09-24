import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        // 입력 : 원의 반지름
        // 반지름 : 정수입력
        // 출력 : 원의 면적
        // 면적 : 실수 출력
        final double PI = 3.141592;
        double radius;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.print("반지름 :");
        String radius_ = input.nextLine();
        //radius = Integer.parseInt(radius_);
        radius = Double.parseDouble(radius_);

        // 면적 : area = 3.14*radius*radius;
        area = PI*radius*radius;

        System.out.println("반지름:"+radius);
        System.out.println("원의 면적 :"+area);

    }


}
