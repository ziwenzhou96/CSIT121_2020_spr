package assignment1;

public class Subject {
    private String code;
    private String name;
    private int point;

    public Subject(String code, String name, int point) {
        this.code = code;
        this.name = name;
        this.point = point;
    }

    public String getCode() {
        return code;
    }

    public int getPoint() {
        return point;
    }

    public String toString(){
        return this.code+" ("+this.name+", "+this.point+"pt)";
    }
}
