package assignment1;

public class Student {
    private String name;
    private String num;
    private String gender;
    private String dob;

    public Student(String name, String num, String gender, String dob) {
        this.name = name;
        this.num = num;
        this.gender = gender;
        this.dob = dob;
    }

    public String toString(){
        return "Student: "+this.name +" ("+this.num +", "+this.gender+", "+this.dob+")";
    }
}
