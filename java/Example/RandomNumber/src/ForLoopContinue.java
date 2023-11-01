public class ForLoopContinue {
    public static void main(String[] args) {

        int num=0;

        // 누적(합), 카운트

        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                num++;
                if((num%2) != 0) {
                    continue;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
