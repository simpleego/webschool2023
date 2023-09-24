public class ForEx {

    public static void main(String[] args) {

        // 1~10까지의 합을 구하시오.

        int sum = 0;
        int index=0;

        for (int i=1;i<=10; i++){
            sum += i;
            index = i;
        }
        System.out.println("i "+ index);
        System.out.println("합은 "+ sum);
    }
}
