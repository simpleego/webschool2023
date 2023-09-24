public class IfTest03 {

    public static void main(String[] args) {

        // 대소비교
        int x = 5;
        int y = 10;

        if(x > y) {
            System.out.println("x가 크다");
            return;
        }
        if(x < y) {
            System.out.println("y가 크다");
            return;
        }
        if(x == y) {
            System.out.println("x와 y가 같다");
        }

        // 비교 연산자, 비교문(if)
        /*
        if(x > y){
            System.out.println("x가 크다");
        }else {
            if(x < y){
                System.out.println("x가 작다");
            }else{
                System.out.println("x가 같다");
            }
        }*/
    }
}
