package assignment1_solution;

import javafx.scene.web.WebHistory;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Enrolment {

    /**
     * @param args the command line arguments
     */
    private Student student;
    private String cName;
    private ArrayList<Subject> eCores;
    private Major eMajor;
    private ArrayList<Subject> eElectives;
    private int totalCredit;
    
    public Enrolment(Student s, String n){
        student = s;
        cName = n;
        eCores = new ArrayList<Subject>(0);
        eMajor = null;
        eElectives = new ArrayList<Subject>(0);
        totalCredit = 0;
    }
    
    public void enrolCores(ArrayList<Subject> c){
        eCores.addAll(c);
        
        for(Subject es:eCores)
            totalCredit+=es.getCredit();
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
    
    public String toString(){
        String s="";
        
        s+=student+"\n";
        
        s+="Cores: \n";
        for(Subject su:eCores)
            s+=su;
        
        s+="\n";
        
        s+=eMajor;
        
        s+="Electives: \n";
        for(Subject su:eElectives)
            s+=su;
        
        s+="-----------------\n";
        
        s+="Total Enrolled Credit: "+totalCredit+"pt";
        
        return s;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Subject CSIT111 = new Subject("CSIT111", "Programming Fundamentals", 6);
        Subject CSIT113 = new Subject("CSIT113", "Problem Solving", 6);
        Subject CSIT114 = new Subject("CSIT114", "System Analysis", 6);
        Subject CSIT115 = new Subject("CSIT115", "Data Management and Security", 6);
        Subject CSIT121 = new Subject("CSIT121", "Object Oriented Design and Programming", 6);
        Subject CSIT127 = new Subject("CSIT127", "Networks and Communications", 6);
        Subject CSIT128 = new Subject("CSIT128", "Introduction to Web Technology", 6);
        Subject CSCI235 = new Subject("CSCI235", "Database Systems", 6);
        Subject CSCI251 = new Subject("CSCI251", "Advanced Programming", 6);
        Subject CSIT214 = new Subject("CSIT214", "IT Project Management", 6);
        Subject MATH221 = new Subject("MATH221", "Mathematics for Computer Science", 6);
        Subject CSCI203 = new Subject("CSCI203", "Algorithms and Data Structures", 6);
        Subject CSIT226 = new Subject("CSIT226", "Human Computer Interaction", 6);
        Subject CSIT314 = new Subject("CSIT314", "Software Development Methodologies", 6);
        Subject CSIT321 = new Subject("CSIT321", "Project", 12);
        Subject CSCI317 = new Subject("CSCI317", "Database Performance Tuning", 6);
        Subject INFO411 = new Subject("INFO411", "Data Mining and Knowledge Discovery", 6);
        Subject CSCI316 = new Subject("CSCI316", "Big Data Mining Techniques and Implementation", 6);
        Subject ISIT312 = new Subject("ISIT312", "Big Data Management", 6);
        Subject CSCI301 = new Subject("CSCI301", "Contemporary Topics in Security", 6);
        Subject CSCI262 = new Subject("CSCI262", "System Security", 6);
        Subject CSCI369 = new Subject("CSCI369", "Ethical Hacking", 6);
        Subject CSIT302 = new Subject("CSIT302", "Cybersecurity", 6);
        Subject CSCI361 = new Subject("CSCI361", "Cryptography and Secure Applications", 6);
        Subject CSCI368 = new Subject("CSCI368", "Network Security", 6);
        Subject CSCI376 = new Subject("CSCI376", "Multicore and GPU Programming", 6);
        Subject CSCI236 = new Subject("CSCI236", "3D Modelling and Animation", 6);
        Subject CSCI336 = new Subject("CSCI336", "Interactive Computer Graphics", 6);
        Subject CSCI366 = new Subject("CSCI366", "Mobile Multimedia", 6);
        Subject CSCI356 = new Subject("CSCI356", "Game Engine Essentials", 6);
        Subject CSCI334 = new Subject("CSCI334", "Software Design", 6);
        Subject ISIT219 = new Subject("ISIT219", "Knowledge and Information Engineering", 6);
        Subject CSCI318 = new Subject("CSCI318", "Software Engineering Practices & Principles", 6);
        Subject ISIT315 = new Subject("ISIT315", "Semantic Web", 6);
        
        Major bigData = new Major("Big Data");
        Subject[] bDataCores={CSCI317, INFO411, CSCI316, ISIT312};
        bigData.addMCores(bDataCores);
        
        Major cyberSec = new Major("Cyber Security");
        Subject[] cyberSecCores={CSCI301, CSCI262, CSCI369, CSIT302};
        cyberSec.addMCores(cyberSecCores);
        
        Major digitalSysSec = new Major("Digital System Security");
        Subject[] digitalSysSecCores={CSCI361, CSCI262, CSCI368, CSCI376};
        digitalSysSec.addMCores(digitalSysSecCores);
        
        Major gameMobDev = new Major("Game and Mobile Development");
        Subject[] gameMobDevCores={CSCI236, CSCI336, CSCI366, CSCI356, CSCI376};
        gameMobDev.addMCores(gameMobDevCores);
        
        Major softEng = new Major("Software Engineering");
        Subject[] softEngCores={CSCI334, ISIT219, CSCI318, ISIT315};
        softEng.addMCores(softEngCores);
        
        Major[] BCSMajors = {bigData, cyberSec, digitalSysSec, gameMobDev, softEng};
        
        Subject[] cCores={CSIT111, CSIT113, CSIT114, CSIT115, CSIT121, CSIT127, 
            CSIT128, CSCI235, CSCI251, CSIT214, MATH221, CSCI203, CSIT226, CSIT314, CSIT321};
        
        Subject[] cEles= {CSCI317, INFO411, CSCI316, ISIT312,CSCI301, CSCI262, 
            CSCI369, CSIT302, CSCI361, CSCI368, CSCI376, CSCI236, CSCI336, 
            CSCI366, CSCI356, CSCI334, ISIT219, CSCI318, ISIT315};
        
        Course bcs = new Course("Bachelor of Computer Science");
        bcs.addCores(cCores);
        bcs.addMajors(BCSMajors);
        bcs.addElectives(cEles);

        enroll(bcs);
    }

    public static void enroll(Course bcs) {
        System.out.println("Welcome to enrol the Bachelor of Computer Science course.");
        System.out.println("The course structure is as follows:");
        System.out.println("-----------------");

        System.out.print(bcs);

        System.out.println("-----------------\n");
        System.out.println("Please input your personal information to complete the enrolment.");

        Scanner input = new Scanner(System.in);
        boolean continueLoop = false;
        String line = "";
        int num = -1;

        do{
            try {
                System.out.print("Please input your full name: ");
                line = input.nextLine().trim();
                if(line.isEmpty()){
                    throw new EmptyInputException("full name");
                }
//                if(line.matches(".*([0-9]|%|#|@){1}.*")){
//                    throw new Exception("The full name cannot include numbers and $%#@");
//                }
                if(!line.matches("[A-Za-z ]*")){
                    throw new Exception("The full name must be alph");
                }
                continueLoop = false;
            }catch (EmptyInputException e) {
                continueLoop = true;
                System.out.println(e.getMessage());
            }catch (Exception e) {
                continueLoop = true;
                System.out.println(e.getMessage());
            }

        }while(continueLoop);

        String sna = line;

        do{
            try{
                System.out.print("Please input your student number: ");
                line = input.nextLine().trim();
                if(line.isEmpty()){
                    throw new EmptyInputException("student number");
                }
                num = Integer.parseInt(line);
                continueLoop = false;
            }catch (EmptyInputException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }
            catch(NumberFormatException e){
                System.out.println("Please enter number!");
                continueLoop = true;
            }
        }while(continueLoop);


        int snu = num;

        do{
            try{
                System.out.print("Please input your gender: ");
                line = input.nextLine().trim();
                if(line.isEmpty()){
                    throw new EmptyInputException("gender");
                }
                if(!line.matches("(Female|Male)")){
                    throw new IllegalArgumentException("Please enter the valid gender(Female|Male)");
                }
                continueLoop = false;
            }catch (EmptyInputException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }
        }while(continueLoop);

        String gen = line;

        do{
            try{
                System.out.print("Please input your date of birth (dd/mm/yyyy): ");
                line = input.nextLine().trim();
                if(line.isEmpty()){
                    throw new EmptyInputException("date of birth");
                }

                assert(line.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")):"Assert:Please enter the valid date of birth (dd/mm/yyyy)";

                if(!line.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
                    throw new IllegalArgumentException("Exception:Please enter the valid date of birth (dd/mm/yyyy)");
                }

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                Date date = df.parse(line);
                continueLoop = false;
            }catch (EmptyInputException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }catch (ParseException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }catch (AssertionError e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }
        }while(continueLoop);

        String db = line;

        Student std = new Student(sna, snu, gen, db);

        Enrolment enrol = new Enrolment(std, bcs.getCName());

        enrol.enrolCores(bcs.getCores());

        System.out.println("\nThanks for your information, we had enrolled you into the Bachelor of Computer Science course.");
        System.out.println("In order to complete the enrolment, please select a major from the list.");
        for (int i = 1; i< bcs.getMajors().size()+1; i++)
            System.out.println(i+": "+bcs.getMajors().get(i-1).getMName());


//        System.out.print("\nPlease input the index number before the major:");

        do{
            try{
                System.out.print("\nPlease input the index number before the major:");
                line = input.nextLine().trim();
                if(line.isEmpty()){
                    throw new EmptyInputException("index number");
                }
                num = Integer.parseInt(line);
                if(num<1||num>5){
                    throw new IllegalArgumentException("index number must in the range(1-5)");
                }
                continueLoop = false;
            }catch (EmptyInputException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }catch(NumberFormatException e){
                System.out.println("Please enter number!");
                continueLoop = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continueLoop = true;
            }
        }while(continueLoop);

        int m = num;

        System.out.println();

        enrol.enrolMajor(bcs.getMajors().get(m-1));

        System.out.println("You select the "+bcs.getMajors().get(m-1).getMName()+" major.");
        System.out.print(bcs.getMajors().get(m-1));

        input.nextLine();

        System.out.println("In order to complete the enrolment, please select selective subjects from the list.\n");
        System.out.println("Electives:");
        for(Subject es:bcs.getElectives())
            System.out.print(es);

        System.out.println();

        while(enrol.getTotalCredit()<bcs.getCCredit()){
            try{
                int n = (bcs.getCCredit()-enrol.getTotalCredit())/6;

                System.out.print("Please select "+n+" more elective subjects by inputing the subject codes (seperate by comma):");

                String[] subs = input.nextLine().split(",");

                for(String s:subs){
                    if(s.trim().isEmpty()){
                        throw new EmptyInputException("elective subjects");
                    }
                }

                if(subs.length==0){
                    throw new EmptyInputException("elective subjects");
                }

                boolean hasSubject = false;
                for(String s:subs){
                    try{
                        hasSubject = false;
                        for(Subject es:bcs.getElectives()){
                            if(es.getCode().equals(s)){
                                enrol.enrolElective(es);
                                hasSubject = true;
                                continue;
                            }

                        }
                        if(!hasSubject) {
                            throw new IllegalArgumentException("The electives " + s + " doesn't exist.");
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
            }catch (EmptyInputException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nCongratulatoins. You had completed the enrolment to "+bcs.getCName()+".");
        System.out.println("--------------------");
        System.out.println(enrol);
    }

}
