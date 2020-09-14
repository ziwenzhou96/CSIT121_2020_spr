package class_3_inheritance;

public class Alarm {
    private String name;
    private int hour;
    private int mintue;

    public Alarm(String name, int hour, int mintue) throws Exception {
        this.name = name;
        if(hour<0||hour>24) throw new Exception("invalid hour");
        this.hour = hour;
        if(mintue<0||mintue>60) throw new Exception("invalid mintue");
        this.mintue = mintue;
    }

    public Alarm(int hour, int mintue) throws Exception {
        this.name = "N/A";
        if(hour<0||hour>24) throw new Exception("invalid hour");
        this.hour = hour;
        if(mintue<0||mintue>60) throw new Exception("invalid mintue");
        this.mintue = mintue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws Exception {
        if(hour<0||hour>24) throw new Exception("invalid hour");
        this.hour = hour;
    }

    public int getMintue() {
        return mintue;
    }

    public void setMintue(int mintue) throws Exception {
        if(mintue<0||mintue>60) throw new Exception("invalid mintue");
        this.mintue = mintue;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "name='" + name + '\'' +
                ", hour=" + hour +
                ", mintue=" + mintue +
                '}';
    }
}
