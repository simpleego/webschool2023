public class IncrementDecrement {

    public static void main(String[] args) {
        int x = 10;
        int y = 10;

        int resultX;
        int resultY;

        resultX = x++;  //x = x + 1;
        resultY = --y;

        System.out.println("result x : " + resultX);
        System.out.println(" x : " + x);

        System.out.println("result y : " + resultY);
        System.out.println(" y : " + y);
    }
}
