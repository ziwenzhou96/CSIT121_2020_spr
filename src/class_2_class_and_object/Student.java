package class_2_class_and_object;

public class Student {
    private String name;
    private String dob;
    private String sex;
    private String stNum;

    public Student() {
        this("","","","");
    }

    public Student(String name, String dob, String sex, String stNum) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.stNum = stNum;
    }

    public Student(Student other) {
        this(other.name,other.dob,other.sex,other.stNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStNum() {
        return stNum;
    }

    public void setStNum(String stNum) {
        this.stNum = stNum;
    }

    public void print() {
        System.out.println(this.name+"\t\t"+"("+this.stNum+")");
    }
}
