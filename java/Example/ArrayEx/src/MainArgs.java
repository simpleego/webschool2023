public class MainArgs {
    public static void main(String[] args) {

        if (args.length > 0){
            for (int i = 0; i < args.length; i++) {
                System.out.println(" "+args[i]);

                if(args[0].equals("-h")){
                    System.out.println("옵션 -h는 도움말 입니다. ");

                }
            }
        }
        System.out.println("매개변수가 없습니다. \n필요한 매개변수를 입력하세요 ");

    }
}
