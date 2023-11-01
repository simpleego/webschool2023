import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // 난수 객체 생성
        Random generator = new Random();
        int sum = 0;
        int randomNumber;

        for (int i=0; i<6; i++){
            randomNumber = (int)(1+generator.nextDouble()*4)+1;
            System.out.println(randomNumber);
        }

    }
}