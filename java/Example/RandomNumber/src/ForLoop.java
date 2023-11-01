public class ForLoop {
    public static void main(String[] args) {

        int num=0;

        // 누적(합), 카운트

        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                System.out.print(++num + " ");
            }
            System.out.println();
        }
    }
}
