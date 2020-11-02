package assignment3;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author fenghui
 */
public class Postgraduate extends Student{

    private String bachelorCompletion, masterCompletion;
    
    public Postgraduate(){
        this("NA",0,"NA","NA","NA","NA");
    }
    
    public Postgraduate(String name, int num, String g, String db, String bc, String mc){
        super(name,num,g,db);
        bachelorCompletion=bc;
        masterCompletion=mc;
    }
    
    @Override
    public String getExpectedCompletion() {
        return masterCompletion;
    }

    @Override
    public void setExpectedCompletion(String ec) {
        masterCompletion=ec;
    }
    
    @Override
    public String toString(){
        String s="";
        s+=super.toString();
        s+="\nExpected Master Graduation: "+getExpectedCompletion();
        s+="\n----------------\n";
        return s;
    }
    
    public String getBachelorCompletion() {
        return bachelorCompletion;
    }

    public void setBachelorCompletion(String bc) {
        bachelorCompletion=bc;
    }  
}
