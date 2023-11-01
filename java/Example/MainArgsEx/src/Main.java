// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        if(args.length >0){
            for (int i = 0; i < args.length; i++) {
                System.out.println(" "+args[i]);

                if(args[0].equals("-h")){
                    System.out.println("help.");
                }
            }
        }else {
            System.out.println("no parameter");
        }

    }
}