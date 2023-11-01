import java.util.Random;

public class RandomEx {
    public static void main(String[] args) {

        // 난수 객체 생성
        //Random generator = new Random();
        int sum = 0;
        int randomNumber;
        int max=10;
        int min=5;
        int range = max-min;

        for (int i=0; i<60; i++){
            randomNumber = (int)(Math.random()*range+1)+5;
            System.out.println(randomNumber);
        }

    }
}