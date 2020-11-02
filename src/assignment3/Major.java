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
public class Major implements Cloneable, Serializable {
    private static final long serialVersionUID = 876323262645176354L;

    private String mName;
    private ArrayList<Subject> mCores=new ArrayList<Subject>(0);


    public Major(){
      this("No Major");
    }

    public Major(String n){
      mName = n;
      //mCores = new ArrayList<Subject>(0);
    }

    public void addMCores(Subject[] cores){
      mCores.addAll(Arrays.asList(cores));
    }

    public ArrayList<Subject> getMCores(){
      return mCores;
    }

    public void addSubject(Subject sub){
      mCores.add(sub);
    }

    @Override
    public String toString(){
      String s="";

      s+=mName+" Major\n";

      for(Subject sub:mCores)
          s+= sub;

      s+="\n";
      return s;
    }

    public String getMName(){
      return mName;
    }

    public boolean isIncluded(Subject s){
      boolean b = false;

      for(Subject mc: mCores)
          b=b||mc.isSame(s);

      //System.out.println(mName+" includes "+ s.getCode()+": "+b);

      return b;
    }

    @Override
    public Major clone() throws CloneNotSupportedException {
      Major cMajor = (Major) super.clone();

      cMajor.mName=this.mName;
      cMajor.mCores=new ArrayList<Subject>(0);

      for(Subject subject: this.mCores)
          cMajor.addSubject(subject.clone());

      return cMajor; //To change body of generated methods, choose Tools | Templates.
    }
}
