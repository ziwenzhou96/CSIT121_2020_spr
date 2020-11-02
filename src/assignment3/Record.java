package assignment3;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Record implements Cloneable{

    /**
     * @param args the command line arguments
     */
    
    enum Status {ACTIVE,COMPLETE,NA}
    
    private String CNAME;
    private ArrayList<Subject> eCores;
    private Major eMajor;
    private ArrayList<Subject> eElectives;
    private int totalCredit;
    private Status status = Status.NA;
    
    public Record(String n){
        CNAME = n;
        eCores = new ArrayList<Subject>(0);
        eMajor = null;
        eElectives = new ArrayList<Subject>(0);
        totalCredit = 0;
    }
    
    public Record(){
        this("");
    }
    
    public String getCourseName(){
        return CNAME;
    }
    
    public void enrolCores(ArrayList<Subject> c){
        eCores.addAll(c);
        
        for(Subject es:eCores)
            totalCredit+=es.getCredit();
    }
    
    public void enrolCore(Subject c){
        eCores.add(c);
        
        totalCredit+=c.getCredit();
    }
    
    public void enrolMajor(Major m){
        eMajor = m;
        
        for(Subject es:eMajor.getMCores())
            totalCredit+=es.getCredit();
    }
    
    public void enrolElective(Subject s){
        if(!isEnrolled(s)){
            eElectives.add(s); 
            totalCredit+=s.getCredit();
        }
            
    }
    
    public int getTotalCredit(){
        return totalCredit;
    }
    
    public boolean isEnrolled(Subject s){
        Boolean b = false;
        
        b=b||eMajor.isIncluded(s);
        
        for(Subject es:eElectives)
            b=b||es.isSame(s);
        
        for(Subject ec:eCores)
            b=b||ec.isSame(s);
        
        return b;
    }
    
    @Override
    public String toString(){
        String s="";
                
        s+="\nCourse Name: "+CNAME+"\t("+status+")\n\n";
        
        s+="Cores: \n";
        for(Subject su:eCores)
            s+=su;
        
        s+="\n";
        
        s+=eMajor;
        
        s+="Electives: \n";
        for(Subject su:eElectives)
            s+=su;
        
        s+="Total Enrolled Credit: "+totalCredit+"pt\n\n";
        
        return s;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public void setStatus(Status s){
        status=s;
    }
    
    @Override
    public Record clone() throws CloneNotSupportedException {
        Record cRecord = (Record) super.clone(); //To change body of generated methods, choose Tools | Templates.
        
        cRecord.CNAME=this.CNAME;
        cRecord.eCores=new ArrayList<Subject>(0);
        cRecord.eElectives=new ArrayList<Subject>(0);
        cRecord.status=this.status;
        cRecord.totalCredit=this.totalCredit;
        cRecord.eMajor=null;
        
        cRecord.enrolMajor(eMajor.clone());
        
        for(Subject core:eCores)
            cRecord.enrolCore(core.clone());
        
        for(Subject ele:eElectives)
            cRecord.enrolElective(ele.clone());
        
        return cRecord;
    }
}
