package class_3_inheritance;

public class Time {
    private int hour,mintue,second;

    public Time(int hour, int mintue, int second) {
        this.hour = hour;
        this.mintue = mintue;
        this.second = second;
    }

    public Time(int hour, int mintue) {
        this.hour = hour;
        this.mintue = mintue;
        this.second = 0;
    }

    public Time(int hour) {
        this.hour = hour;
        this.mintue = 0;
        this.second = 0;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMintue() {
        return mintue;
    }

    public void setMintue(int mintue) {
        this.mintue = mintue;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", mintue=" + mintue +
                ", second=" + second +
                '}';
    }
}

class Timer extends Time{
    public Timer(int hour, int mintue, int second) {
        super(hour, mintue, second);
    }

    public Timer(int hour, int mintue) {
        super(hour, mintue);
    }

    public Timer(int hour) {
        super(hour);
    }

    public void setTimer(int hour, int mintue, int second){
        super.setHour(hour);
        super.setMintue(mintue);
        super.setSecond(second);
    }

    public void setTimer(int hour, int mintue){
        super.setHour(hour);
        super.setMintue(mintue);
        super.setSecond(0);
    }

    @Override
    public String toString() {
        return "Timer{"+
                super.toString()+
                "}";
    }
}

class _Alarm extends Time{
    private String alarmName;

    public _Alarm(String alarmName, int hour, int mintue) {
        super(hour, mintue);
        this.alarmName = alarmName;
    }

    public _Alarm(int hour, int mintue) {
        super(hour, mintue);
    }

    @Override
    public String toString() {
        return "_Alarm{" +
                "alarmName='" + alarmName + '\'' +
                super.toString()+
                '}';
    }
}
