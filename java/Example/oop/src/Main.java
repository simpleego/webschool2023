class Car {
    // 상태
    // 색상, 기어, 속도
    String color = "red";
    int gear = 1;
    int speed = 0;

    // 동작
    // 기어변경, 감속, 가속
    public void changeGear(int gear){
        if(gear > 5) {
            System.out.println("최대 5단까지 가능");
            return;
        }
        this.gear = gear;
        System.out.println(" 현재 기어 :" + gear);
    }

    public void speedUp(){
        System.out.println("가속합니다.");
    }
    public void speedDown(){
        System.out.println("감속합니다.");
    }
}

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.changeGear(3);
        car.changeGear(1);
        car.changeGear(10);
        car.gear = 7;
        System.out.println(car.gear);

        Car car1 = new Car();
        car1.changeGear(3);
        car1.changeGear(1);
        car1.changeGear(10);
        System.out.println(car1.gear);

        TV tv = new TV();
        int vol = tv.volumeUp();
        vol = tv.volumeUp();
        System.out.println("현재 볼륨 :"+vol);
    }
}