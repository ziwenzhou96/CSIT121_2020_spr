package class_2_class_and_object;

import java.util.ArrayList;

public class Subject {
    private String name;
    private String code;
    private String session;
    private String year;
    private ArrayList<Student> studentList;

    public Subject(String name, String code, String session, String year) {
        this.name = name;
        this.code = code;
        this.session = session;
        this.year = year;
        this.studentList = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void enrolStudent(Student student){
        this.studentList.add(student);
    }

    public void withdrawStudent(Student student){
        this.studentList.remove(student);
    }

    public void print(){
        System.out.println("Subject Name: "+this.name+" ("+this.code+","+this.session+" "+this.year+")");
        System.out.println("Enrolled Students:");
        for(Student st:this.studentList){
            st.print();
        }
    }
}
