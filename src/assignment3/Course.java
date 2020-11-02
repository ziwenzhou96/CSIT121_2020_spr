package assignment3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 876323262645176354L;

    private String cName;
    private ArrayList<Subject> cores;
    private ArrayList<Major> majors;
    private ArrayList<Subject> electives;
    private int cCredit;
    
    public Course(String n, int cc){
        cName = n;
        cCredit = cc;
        cores = new ArrayList<Subject>(0);
        majors = new ArrayList<Major>(0);
        electives = new ArrayList<Subject>(0);
    }
    
    public void addCores(Subject[] co){       
        cores.addAll(Arrays.asList(co));
    }
    
    public void addMajors(Major[] ma){
        majors.addAll(Arrays.asList(ma));
    }
    
    public void addElectives(Subject[] el){
        electives.addAll(Arrays.asList(el));
    }
    
    public ArrayList<Subject> getCores(){
        return cores;
    }
    
    public ArrayList<Subject> getElectives(){
        return electives;
    }
    
    public String toString(){
        String s="Course: ";
        
        s+=cName+"\n\n";
        
        s+="Cores: \n";
        for(Subject su:cores)
            s+=su;
        
        s+="\n";
        
        for(Major m:majors)
            s+=m;
        
        s+="Electives: \n";
        
        for(Subject su:electives)
            s+=su;
        
        return s;
    }
    
    public String getCName(){
        return cName;
    }
    
    public ArrayList<Major> getMajors(){
        return majors;
    }
    
    public int getCCredit(){
        return cCredit;
    }
}
