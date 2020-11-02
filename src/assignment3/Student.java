package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
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
public abstract class Student implements Enrollment, Cloneable {
    
    private String stName, gender, dob;
    private int stNum;
    private ArrayList<Record> records;
    
    public Student(String name, int num, String g, String db){
//        if(name.isEmpty()){
//            throw new InputMismatchException("Student number is not inputted.");
//        }
//        if(g.isEmpty()){
//            throw new InputMismatchException("Student number is not inputted.");
//        }

        if(!db.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
            throw new InputMismatchException("The DOB format is wrong: "+db);
        }

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(db);
        } catch (ParseException e) {
            throw new InputMismatchException("The input date does not exist.");
        }

        stName=name;
        stNum=num;
        gender=g;
        dob=db;
        records = new ArrayList<Record>(0);    
    }
    
    public Student(){
        this("NA",0,"NA","NA");
    }
    
    public String getSName(){
        return stName;
    }
    
    public void setSName(String s){
        stName=s;
    }
    
    public int getSNum(){
        return stNum;
    }
    
    public void setSNum(int n){
        stNum=n;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String g){
        gender=g;
    }
    
    public String getDOB(){
        return dob;
    }
    
    public void setDOB(String db){
        dob=db;
    }
    
    public void addRecord(Record r){
        records.add(r);
    }
    
    public void deletedRecord(int index){
        records.remove(index);
    }
    
    public Record getRecord(int index){
        return records.get(index);
    }
    public ArrayList<Record> getRecords(){
        return records;
    }
    
    public abstract String getExpectedCompletion();
    
    public abstract void setExpectedCompletion(String ec);

    public void saveToFile(){
        Formatter formatter = null;
        try {
            formatter= new Formatter(new File(this.stName+"_"+this.records.get(0).getCourseName()+".txt"));
            formatter.format(this.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(formatter != null){
                formatter.close();
            }
        }
    }

    @Override
    public String toString(){
        String s="----------------\n";
        
        s+="Student: "+getSName()+" ("+getSNum()+", "+getGender()+", "+getDOB()+") \n";
        
        for(Record r:records)
            s+=r;
        
        return s;
    }
    
    @Override
    public Student clone() throws CloneNotSupportedException {
      Student student = (Student) super.clone();
      student.records = (ArrayList<Record>) records.clone();
        
      return student; //To change body of generated methods, choose Tools | Templates.
    }
}
