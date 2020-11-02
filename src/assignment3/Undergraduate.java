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
public class Undergraduate extends Student {
    private String bachelorCompletion;
    
    public Undergraduate(){
        this("NA",0,"NA","NA","NA");
    }
    
    public Undergraduate(String name, int num, String g, String db, String bc){
        super(name,num,g,db);
        bachelorCompletion=bc;
    }
    
    @Override
    public String getExpectedCompletion() {
        return bachelorCompletion;
    }

    @Override
    public void setExpectedCompletion(String ec) {
        bachelorCompletion=ec;
    }
    
    @Override
    public String toString(){
        String s="";
        s+=super.toString();
        s+="Expected Bachelor Graduation: "+getExpectedCompletion();
        s+="\n----------------\n";
        
        return s;
    }
    
}
