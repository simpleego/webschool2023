public class ArrayInit {

    public static void main(String[] args) {
        int[] jumsu = {50,60,90,78,88,90,71,54,58,92};
        int[] jumsu1;

        jumsu1 = jumsu;

        for (int i = 0; i < jumsu1.length; i++) {
            System.out.println(i+":"+jumsu[i]);
        }

        int count=0;
        for (int x: jumsu) {
            System.out.println(++count+":"+x);
        }
    }

}
