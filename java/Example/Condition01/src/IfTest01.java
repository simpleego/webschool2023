public class IfTest01 {

    public static void main(String[] args) {
        // 입력 : 생년월일(태어난 년도)
        // 출력 : 성년/미성년
        // 성년 : 20세이상
        int year;
        int age;

        // 1. 태어난 연도 입력
        year = 2006;

        // 2. 올해를 기준으로 나이 계산
        age = 2023 - year;

        // 3. 성년기준으로 판별
        if(age >= 20){
            System.out.println("성년입니다.");
        }else {
            System.out.println("미성년입니다.");
        }

        // 4. 결과 출력

    }
}
