package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class StudentSystem {
    private static ArrayList<Student> students = new ArrayList<Student>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Course bcs,mcs;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    Files.newInputStream(Paths.get("bcs.ser"))
            );
            bcs = (Course)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ois = null;
        try {
            ois = new ObjectInputStream(
                    Files.newInputStream(Paths.get("mcs.ser"))
            );
            mcs = (Course)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Welcome to enrol the Bachelor of Computer Science course.");
        System.out.println("The course structure is as follows:");
        System.out.println("-----------------");

        System.out.print(bcs);

        System.out.println("-----------------\n");
        System.out.println("Please input your personal information to complete the enrolment.");
        System.out.print("Please input your full name: ");

        Scanner input = new Scanner(System.in);

        String sna = input.nextLine();

        System.out.print("Please input your student number: ");

        int snu = input.nextInt();

        System.out.print("Please input your gender: ");

        String gen = input.next();

        System.out.print("Please input your date of birth (dd/mm/yyyy): ");

        String db = input.next();

        /********************************/
        LocalDate date = LocalDate.now();
        int year = date.getYear()+2;
        int month = date.getMonthValue();
        String semester = "";

        if(month<7){
            semester = "Spring";
        }else{
            semester = "Autumn";
        }
        /********************************/

        Student std = new Undergraduate(sna, snu, gen, db, semester+"/"+year);

        Record record = new Record(bcs.getCName());

        record.setStatus(Record.Status.ACTIVE);

        std.addRecord(record);

        record.enrolCores(bcs.getCores());

        System.out.println("\nThanks for your information, we had enrolled you into the Bachelor of Computer Science course.");
        System.out.println("In order to complete the enrolment, please select a major from the list.");
        for (int i = 1; i< bcs.getMajors().size()+1; i++)
            System.out.println(i+": "+bcs.getMajors().get(i-1).getMName());


        System.out.print("\nPlease input the index number before the major:");


        int m = input.nextInt();

        System.out.println();

        record.enrolMajor(bcs.getMajors().get(m-1));

        System.out.println("You select the "+bcs.getMajors().get(m-1).getMName()+" major.");
        System.out.print(bcs.getMajors().get(m-1));

        input.nextLine();

        System.out.println("In order to complete the enrolment, please select selective subjects from the list.\n");
        System.out.println("Electives:");
        for(Subject es:bcs.getElectives())
            System.out.print(es);

        System.out.println();

        while(record.getTotalCredit()<bcs.getCCredit()){
            int n = (bcs.getCCredit()-record.getTotalCredit())/6;

            System.out.print("Please select "+n+" more elective subjects by inputing the subject codes (seperate by comma):");

            String[] subs = input.nextLine().split(",");

            for(String s:subs){
                for(Subject es:bcs.getElectives()){
                    if(es.getCode().equals(s)){
                        record.enrolElective(es);
                        continue;
                    }

                }
            }
        }


        System.out.println();
        System.out.println("Welcome to enrol the Master of Computer Science course.");
        System.out.println("The course structure is as follows:");
        System.out.println("-----------------");

        System.out.print(mcs);

        System.out.println("-----------------\n");
        System.out.println("Please input your personal information to complete the enrolment.");
        System.out.print("Please input your full name: ");

        input = new Scanner(System.in);

        sna = input.nextLine();

        System.out.print("Please input your student number: ");

        snu = input.nextInt();

        System.out.print("Please input your gender: ");

        gen = input.next();

        System.out.print("Please input your date of birth (dd/mm/yyyy): ");

        db = input.next();

        System.out.print("Please input the time (Session/Year) you received your bachelor degree: ");

        String bCompletion = input.next();

        /********************************/
        date = LocalDate.now();
        year = date.getYear()+2;
        month = date.getMonthValue();
        semester = "";

        if(month<7){
            semester = "Spring";
        }else{
            semester = "Autumn";
        }
        /********************************/

        Student mstd = new Postgraduate(sna, snu, gen, db, bCompletion, semester+"/"+year);

        Record bRecord = null;
        try {
            bRecord = (Record)record.clone();
            bRecord.setStatus(Record.Status.COMPLETE);
            mstd.addRecord(bRecord);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        Record mRecord = new Record(mcs.getCName());
        mRecord.setStatus(Record.Status.ACTIVE);
        mstd.addRecord(mRecord);

        mRecord.enrolCores(mcs.getCores());

        System.out.println("\nThanks for your information, we had enrolled you into the Master of Computer Science course.");
        System.out.println("In order to complete the enrolment, please select a major from the list.");
        for (int i = 1; i< mcs.getMajors().size()+1; i++)
            System.out.println(i+": "+mcs.getMajors().get(i-1).getMName());

        System.out.print("\nPlease input the index number before the major:");

        m = input.nextInt();

        System.out.println();

        mRecord.enrolMajor(mcs.getMajors().get(m-1));

        System.out.println("You select the "+mcs.getMajors().get(m-1).getMName()+" major.");
        System.out.print(mcs.getMajors().get(m-1));

        input.nextLine();

        System.out.println("In order to complete the enrolment, please select selective subjects from the list.\n");
        System.out.println("Electives:");
        for(Subject es:mcs.getElectives())
            System.out.print(es);

        System.out.println();

        while(mRecord.getTotalCredit()<mcs.getCCredit()){
            int n = (mcs.getCCredit()-mRecord.getTotalCredit())/6;

            System.out.print("Please select "+n+" more elective subjects by inputing the subject codes (seperate by comma):");

            String[] subs = input.nextLine().split(",");

            for(String s:subs){
                for(Subject es:mcs.getElectives()){
                    if(es.getCode().equals(s)){
                        mRecord.enrolElective(es);
                        continue;
                    }

                }
            }
        }

        students.add(std);
        students.add(mstd);

        System.out.println("\nCongratulatoins. You had completed the enrolment to "+mcs.getCName()+".");
        System.out.println("The enrolment records of the students are as follows:");
//        System.out.println(std);
//        for(Student s:students){
//            System.out.println(s);
//        }

        Formatter formatter = null;
        try {
            formatter = new Formatter(new File("student.txt"));
            for(Student s:students){
                formatter.format("%s",s);
                formatter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(formatter == null){
                formatter.close();
            }
        }
    }

    public void enroll(Course cs) {

    }
}
