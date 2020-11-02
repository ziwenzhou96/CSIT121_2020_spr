package assignment3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class StudentSystem {

    private static ArrayList<Student> students;
    private StudentEnrolmentView studentEnrolmentView;
    private Course bcs,mcs;

    public StudentSystem() {
        students = new ArrayList<Student>(0);
        loadCourseFromFile();
        studentEnrolmentView = new StudentEnrolmentView(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {

    }

    public void loadCourseFromFile(){
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
    }

    public Course getBCourse(){
        return bcs;
    }

    public Course getMCourse(){
        return mcs;
    }

    public void enrollBStudent(String sna,int snu,String gen, String db, int m,ArrayList<String> electives){
        /********************************/
        LocalDate date = LocalDate.now();
        int year = date.getYear()+3;
        int month = date.getMonthValue();
        String semester = "";

        if(month<7){
            semester = "Spring";
        }else{
            semester = "Autumn";
        }
        /********************************/

        Student ug = new Undergraduate(sna, snu, gen, db, semester+"/"+year);

        Record bcsRecord = new Record("Bachelor of Computer Science");
        bcsRecord.enrolCores(bcs.getCores());
        bcsRecord.enrolMajor(bcs.getMajors().get(m));

        for(String s:electives){
            for(Subject es:bcs.getElectives()){
                if(es.getCode().equals(s)){
                    bcsRecord.enrolElective(es);
                    continue;
                }
            }
        }

        int n = (bcs.getCCredit()-bcsRecord.getTotalCredit())/6;

        if(n>0){
            throw new InputMismatchException("Please enroll "+n+" more subjects.");
        }else{
            bcsRecord.setStatus(Record.Status.ACTIVE);
            ug.addRecord(bcsRecord);
            students.add(ug);
            ug.saveToFile();
        }
    }

    public void enrollMStudent(String sna,int snu,String gen, String db, int m,ArrayList<String> electives){
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
        Student pg = new Postgraduate(sna, snu, gen, db, "", semester+"/"+year);
        Record mcsRecord = new Record("Master of Computer Science");
        mcsRecord.enrolMajor(mcs.getMajors().get(m-1));

        mcsRecord.enrolCores(mcs.getCores());

        for(String s:electives){
            for(Subject es:mcs.getElectives()){
                if(es.getCode().equals(s)){
                    mcsRecord.enrolElective(es);
                    continue;
                }
            }
        }

        int n = (mcs.getCCredit()-mcsRecord.getTotalCredit())/6;

        if(n>0){
            throw new InputMismatchException("Please enroll "+n+" more subjects.");
        }else{
            mcsRecord.setStatus(Record.Status.ACTIVE);
            pg.addRecord(mcsRecord);
            pg.saveToFile();
        }
    }
}
