public class TV {
    // 상태, 속성
    int channel;
    int volume=0;
    boolean power;

    // 동작, 행위
    // 전원관리, 채널관리, 볼륨관리
    public void power(){
        if(power){
            power = false;   // 전원 on
        }else {
            power = true;   // 전원 on
        }
    }

    public void changeChennel(int channel){
        this.channel = channel;
    }
    public void chennelUp(){
       channel++;
    }
    public void chennelDown(){
       channel--;
    }

    public int volumeUp(){
       return ++volume;
    }
    public int volumeDown(){
        return --volume;
    }
}
