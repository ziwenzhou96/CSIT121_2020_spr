package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Enrolment {
    private Student student;
    private Course course;
    private Major major;
    private ArrayList<Subject> cEles;
    private int credit;

    public static void main(String[] args) {
        Subject CSIT111 = new Subject("CSIT111","Programming Fundamentals",6);
        Subject CSIT113 = new Subject("CSIT113","Problem Solving",6);
        Subject CSIT114 = new Subject("CSIT114","System Analysis",6);
        Subject CSIT115 = new Subject("CSIT115","Data Management and Security",6);
        Subject CSIT121 = new Subject("CSIT121","Object Oriented Design and Programming",6);
        Subject CSIT127 = new Subject("CSIT127","Networks and Communications",6);
        Subject CSIT128 = new Subject("CSIT128","Introduction to Web Technology",6);
        Subject CSCI235 = new Subject("CSCI235","Database Systems",6);
        Subject CSCI251 = new Subject("CSCI251","Advanced Programming",6);
        Subject CSIT214 = new Subject("CSIT214","IT Project Management",6);
        Subject MATH221 = new Subject("MATH221","Mathematics for Computer Science",6);
        Subject CSCI203 = new Subject("CSCI203","Algorithms and Data Structures",6);
        Subject CSIT226 = new Subject("CSIT226","Human Computer Interaction",6);
        Subject CSIT314 = new Subject("CSIT314","Software Development Methodologies",6);
        Subject CSIT321 = new Subject("CSIT321","Project",12);
        Subject CSCI317 = new Subject("CSCI317","Database Performance",6);
        Subject INFO411 = new Subject("INFO411","Data Mining and Knowledge Discovery",6);
        Subject CSCI316 = new Subject("CSCI316","Big Data Mining Techniques and Implementation",6);
        Subject ISIT312 = new Subject("ISIT312","Big Data Management",6);
        Subject CSCI301 = new Subject("CSCI301","Contemporary Topics in Security",6);
        Subject CSCI262 = new Subject("CSCI262","System Security",6);
        Subject CSCI369 = new Subject("CSCI369","Ethical Hacking",6);
        Subject CSIT302 = new Subject("CSIT302","Cybersecurity",6);
        Subject CSCI361 = new Subject("CSCI361","Cryptography and Secure Applications",6);
        Subject CSCI368 = new Subject("CSCI368","Network Security",6);
        Subject CSCI376 = new Subject("CSCI376","Multicore and GPU Programming",6);
        Subject CSCI236 = new Subject("CSCI236","3D Modelling and Animation*",6);
        Subject CSCI336 = new Subject("CSCI336","Interactive Computer Graphics",6);
        Subject CSCI366 = new Subject("CSCI366","Mobile Multimedia",6);
        Subject CSCI356 = new Subject("CSCI356","Game Engine Essentials",6);
        Subject CSCI334 = new Subject("CSCI334","Software Design",6);
        Subject ISIT219 = new Subject("ISIT219","Knowledge and Information Engineering",6);
        Subject CSCI318 = new Subject("CSCI318","Software Engineering Practices & Principles",6);
        Subject ISIT315 = new Subject("ISIT315","Semantic Web",6);


        Major bigData = new Major("Big Data");
        Subject[] bigDataCores = {CSCI317, INFO411, CSCI316, ISIT312};
        bigData.addMCores(bigDataCores);

        Major cyberSecurity = new Major("Cyber Security");
        Subject[] cyberSecCores = {CSCI301, CSCI262, CSCI369, CSIT302};
        cyberSecurity.addMCores(cyberSecCores);

        Major digitalSystemsSecurity = new Major("Digital Systems Security Major");
        Subject[] digitalSystemsSecurityCores = {CSCI361, CSCI262, CSCI368, CSCI376};
        digitalSystemsSecurity.addMCores(digitalSystemsSecurityCores);

        Major gameAndMobileDevelopment = new Major("Game and Mobile Development");
        Subject[] gameAndMobileDevelopmentCores = {CSCI236, CSCI336, CSCI366, CSCI356};
        gameAndMobileDevelopment.addMCores(gameAndMobileDevelopmentCores);

        Major softwareEngineering = new Major("Software Engineering");
        Subject[] softwareEngineeringCores = {CSCI334, ISIT219, CSCI318, ISIT315};
        softwareEngineering.addMCores(softwareEngineeringCores);

        Major[] bachelorComputerScienceMajors = {bigData, cyberSecurity, digitalSystemsSecurity, gameAndMobileDevelopment, softwareEngineering};
        Subject[] courseCoresSubject = {CSIT111, CSIT113, CSIT114, CSIT115, CSIT121, CSIT127, CSIT128, CSCI235, CSCI251, CSIT214, MATH221, CSCI203, CSIT226, CSIT314, CSIT321};
        Subject[] courseElectiveSubject = {CSCI317, INFO411, CSCI316, ISIT312, CSCI301, CSCI262, CSCI369, CSIT302, CSCI361, CSCI262, CSCI368, CSCI376, CSCI236, CSCI336, CSCI366, CSCI356, CSCI334, ISIT219, CSCI318, ISIT315};

        Course bachelorComputerScience = new Course("Bachelor of Computer Science");
        bachelorComputerScience.addCores(courseCoresSubject);
        bachelorComputerScience.addMajors(bachelorComputerScienceMajors);
        bachelorComputerScience.addElectives(courseElectiveSubject);

        Enrolment.displayCourse(bachelorComputerScience);

        Student student = Enrolment.collectPersonalInformation();
        Enrolment enrolment = Enrolment.enrolStudentToCoreSubjects(student,bachelorComputerScience);
        enrolment.selectMajor();
        enrolment.selectElectiveSubjects();
        enrolment.displayFinalEnrolmentRecord();
    }

    private Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.major = null;
        this.cEles = new ArrayList<Subject>();
        this.credit = this.course.getCoreTotalCreditPoints();
    }

//    private Enrolment(Student student, Course course, Major major) {
//        this.student = student;
//        this.course = course;
//        this.major = major;
//        this.cEles = new ArrayList<Subject>();
//        this.credit = this.course.getCoreTotalCreditPoints()+this.major.getTotalCreditPoints();
//    }


//    public int getCredit() {
//        return credit;
//    }

    private void addElectives(String code){
        code = code.trim().toUpperCase();
        for(Subject core:this.course.getcEles()){
            if(core.getCode().equals(code)&&!this.major.containSubject(code)&&!this.containSubject(code)){
                this.cEles.add(core);
                this.credit+=core.getPoint();
            }
        }
    }

    private boolean checkCredit(){
        return this.credit>=Course.MINIMAL_CREDIT_POINTS_REQUIREMENT;
    }

    private boolean containSubject(String code){
        for(Subject sub:this.cEles){
            if(sub.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public static void displayCourse(Course cs){
        System.out.println("Welcome to enrol the "+cs.getName()+" course.");
        System.out.println("The course structure is as follows:");
        System.out.println("-----------------");
        System.out.println(cs.toString());
        System.out.println("-----------------");
    }

    public static Student collectPersonalInformation(){
        System.out.println();
        System.out.println("Your following personal information are required to complete the enrolment.");
        Scanner input = new Scanner(System.in);
        String name,num,gender,dob;

        System.out.print("Please input your full name: ");
        name = input.nextLine();
        System.out.print("Please input your student number: ");
        num = input.next();
        System.out.print("Please input your gender: ");
        gender = input.next();
        System.out.print("Please input your date of birth (dd/mm/yyyy):");
        dob = input.next();

        Student student = new Student(name,num,gender,dob);
        return student;
    }

    public static Enrolment enrolStudentToCoreSubjects(Student student, Course course){
        return new Enrolment(student, course);
    }

    public void selectMajor(){
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Thanks for your information. ");
        System.out.println("In order to complete the enrolment, please select a major from the list.");

        System.out.println(this.course.getMajorList());

        System.out.print("Please input the index number before the major: ");

        this.major = this.course.getMajor(input.nextInt()-1);
        this.credit += this.major.getTotalCreditPoints();

        System.out.println("You enrolled into:");
        System.out.println(this.major.toString());
    }

    public void selectElectiveSubjects(){
        System.out.println();
        System.out.println("In order to complete the enrolment, please select selective subjects from the list.\n");

        Subject[] cEles = this.course.getcEles();

        for(Subject s:cEles){
            System.out.println(s.toString());
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        int electiveCredits = Course.MINIMAL_CREDIT_POINTS_REQUIREMENT - this.credit;
        while(electiveCredits>0){
            System.out.print("Please select "+electiveCredits/6+" more elective subjects: ");
            String line = input.nextLine();
            String[] codes = line.split(",");
            for(String code:codes){
                this.addElectives(code);
            }
            electiveCredits = Course.MINIMAL_CREDIT_POINTS_REQUIREMENT - this.credit;
        }
    }

    public void displayFinalEnrolmentRecord(){
        System.out.println();
        System.out.println("Congratulations. You had completed the enrolment to Bachelor of Computer Science course.");
        System.out.println("--------------------");
        System.out.println(this.student.toString());
        System.out.println();

        System.out.println("Core Subjects:");
        for(Subject s:this.course.getcCores()){
            System.out.println(s.toString());
        }
        System.out.println();

        System.out.println("Major: "+this.major.getName());
        for(Subject s:this.major.getSubjects()){
            System.out.println(s.toString());
        }
        System.out.println();

        System.out.println("Electives:");
        for(Subject s:cEles){
            System.out.println(s.toString());
        }

        System.out.println("-----------------");
        System.out.println("Total Enrolled Credit Points: "+this.credit);
    }
}
