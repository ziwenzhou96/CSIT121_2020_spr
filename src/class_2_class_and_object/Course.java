package class_2_class_and_object;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Subject> subjectList;
    private ArrayList<Student> studentList;

    public static void main(String[] args) {
        Course cs = new Course("Bachelor of Computer Science");

        Student amy = new Student("Amy Bell","01/01/2001","Female","100001");
        Student bob = new Student("Bob Brown","02/02/2002","Male","200001");
        Student cindy = new Student("Cindy Ma","03/03/2001","Female","100003");
        Student david = new Student("David Hintz","04/04/2000","Male","100004");

        Subject csit111 = new Subject("Programming Fundamentals","CSIT111","Spring","2020");
        Subject csit121 = new Subject("Object Oriented Design and Programming","CSIT121","Spring","2020");

        cs.addStudent(amy);
        cs.addStudent(bob);
        cs.addStudent(cindy);
        cs.addStudent(david);

        cs.addSubject(csit111);
        cs.addSubject(csit121);

        csit111.enrolStudent(amy);
        csit111.enrolStudent(bob);
        csit111.enrolStudent(cindy);

        csit121.enrolStudent(david);

        cs.print();

        csit111.withdrawStudent(cindy);

        csit121.enrolStudent(cindy);

        cs.print();

    }

    public Course(String name) {
        this.name = name;
        this.subjectList = new ArrayList<Subject>();
        this.studentList = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubject(Subject subject){
        this.subjectList.add(subject);
    }

    public void removeSubject(Subject subject){
        this.subjectList.remove(subject);
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void removeStudent(Student student){
        this.studentList.remove(student);
    }

    public void print(){
        System.out.println("--------------------------");
        System.out.println("Course Name: "+this.name);
        for(Subject sub:subjectList){
            System.out.println();
            sub.print();
        }
        System.out.println("--------------------------");
    }
}
