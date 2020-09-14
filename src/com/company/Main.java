package com.company;

public class Main {
    int a;
    static int b = 10086;

    public static void main(String[] args) {
	// write your code here
//        System.out.println(Student.count);

        Student iris = new Student("iris","01/01/1992");
        Student s2 = new Student("s2","01/01/1992");

//        System.out.println(iris.toString());
//        System.out.println(s2.toString());

        Student s3 = new Student("s3","01/01/1992");
        Student s4 = new Student("s4","01/01/1992");
        Student s5 = new Student("s5","01/01/1992");

//        System.out.println(iris.toString());
//        System.out.println(s2.toString());
//        System.out.println(s3.toString());
//        System.out.println(s4.toString());
//        System.out.println(s5.toString());

//        test();
//        staticTest();

//        System.out.println(a);
//        System.out.println(b);

        String fileText1 = "iris,01/04/1992";
        String fileText2 = "iris,01/04/1992";
        String fileText3 = "iris,01/04/1992";
        String fileText4 = "iris,01/04/1992";

        Student s6 = Student.createStudentByText(fileText1);

        System.out.println(s6.toString());
    }

    public void test() {
        System.out.println("non static");
    }

    public static void staticTest() {
        System.out.println("static");
    }
}

class Student {
    private String name;
    private String stnum;
    private String dob;
    public static int count = 0;

    public Student(String name, String dob) {
        this.name = name;
        this.stnum = "ST"+(++Student.count);
        this.dob = dob;
//        Student.count = Student.count + 1;
    }

    public static Student createStudentByText(String text){
        String[] fields = text.split(",");

        return new Student(fields[0],fields[1]);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stnum='" + stnum + '\'' +
                ", dob='" + dob + '\'' +
                "} count: "+Student.count;
    }
}