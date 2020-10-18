/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;

/**
 *
 * @author fenghui
 */
public abstract class Student implements Enrolment, Cloneable{
    
    private String stName, gender, DOB;
    private int stNum;
    private ArrayList<Record> records;

    public Student() {
    }

    public Student(String name, int num, String g, String dob){
        stName=name;
        stNum=num;
        gender=g;
        DOB=dob;
        records = new ArrayList<>();
    }
    
    public String toString(){
        String s="";

        s += "Student: "+stName+" ("+stNum+", "+gender+", "+DOB+") \n";

        for(Record r:records)
            s+= "\n"+r+"\n";

        return  s;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getStNum() {
        return stNum;
    }

    public void setStNum(int stNum) {
        this.stNum = stNum;
    }

    public abstract void setExpectedCompletion(String expectedCompletion);

    public abstract String getExpectedCompletion();

    @Override
    public void addRecord(Record record) {
        this.records.add(record);
    }

    @Override
    public void deleteRecord(int index) {
        this.records.remove(index);
    }

    @Override
    public Record getRecord(int index) {
        return this.records.get(index);
    }

    @Override
    public ArrayList<Record> getRecords() {
        return this.records;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student obj = (Student)super.clone();

        obj.records = new ArrayList<>();
        for(Record r:this.records)
            obj.records.add((Record) r.clone());

        return obj;
    }
}
