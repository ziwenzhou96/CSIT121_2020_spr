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
public class Subject implements Cloneable, Serializable {
    private static final long serialVersionUID = 876323262645176354L;

    private String sName, code;
    private int credit;
    
    public Subject(String co, String name, int cr){
        sName = name;
        code = co;
        credit = cr;
    }

    public int getCredit(){
        return credit;
    }
    
    @Override
    public String toString(){
        return code+" ("+sName+", "+credit+"pt)\n";
    }
    
    public String getCode(){
        return code;
    }
    
    public boolean isSame(Subject s){
        if(s.getCode().equals(code))
            return true;
        else
            return false;
    } 
    
    @Override
    public Subject clone() throws CloneNotSupportedException {
        return  (Subject) super.clone();
    }
}
