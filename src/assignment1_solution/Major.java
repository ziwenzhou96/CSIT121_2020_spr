package assignment1_solution;

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
enum MajorName{
    BigData, CyberSecurity, DigitialSystemsSecurity, 
    GameandMobileDevelopment, SoftwareEngineering
}

public class Major {
  private String mName;
  private ArrayList<Subject> mCores;
  
  
  public Major(String n){
      mName = n;
      mCores = new ArrayList<Subject>(0);
  }
  
  public void addMCores(Subject[] cores){
      mCores.addAll(Arrays.asList(cores));
  }
  
  public ArrayList<Subject> getMCores(){
      return mCores;
  }
  
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
}
