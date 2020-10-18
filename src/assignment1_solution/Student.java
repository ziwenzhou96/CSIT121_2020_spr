package assignment1_solution;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Student {
    
    private String stName, gender, DOB;
    private int stNum;
    
    public Student(String name, int num, String g, String dob){
        stName=name;
        stNum=num;
        gender=g;
        DOB=dob;
    }
    
    public String toString(){
        return  "Student: "+stName+" ("+stNum+", "+gender+", "+DOB+") \n";
    }

}
