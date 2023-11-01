public class ForLoopBreak {
    public static void main(String[] args) {

        int num=0;

        // 누적(합), 카운트

        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                num++;
                System.out.print(num + " ");
                if(num == 50) break;
            }
            if(num == 50) break;
            System.out.println();
        }
    }
}
