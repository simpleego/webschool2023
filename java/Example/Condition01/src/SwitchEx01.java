public class SwitchEx01 {
    public static void main(String[] args) {
        // switch ~ case : 변수값으로 다중조건처리

        // 입력 : 정수(1~5)
        // 출력 : (하나,둘,셋~~)

        int num = 1;
        String result = "";

        switch (num){
            case 1:
                //result="하나";
                //break;
            case 2:
                result="하나 또는 둘";
                break;
            case 3:
                result="셋";
                break;
            case 4:
                result="넷";
                break;
            case 5:
                result="다섯";
                break;
            default:
                result="숫자가 아님";
        }
        System.out.println("입력한 숫자 "+num+"은 "+result+"입니다.");
    }
}
