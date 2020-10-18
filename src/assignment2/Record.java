package assignment2;

import java.util.ArrayList;

public class Record implements Cloneable{
    private final String CNAME;
    private ArrayList<Subject> eCores;
    private Major eMajor;
    private ArrayList<Subject> eElectives;
    private int totalCredit;
    private Status status;

    enum Status {ACTIVE,COMPLETE,NA};

    public Record(String CNAME) {
        this.CNAME = CNAME;
        this.eCores = new ArrayList<>();
        this.eElectives = new ArrayList<>();
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString(){
        String s="";

        s+="Course Name: "+CNAME+"\t("+status+")\n\n";

        s+="Cores: \n";
        for(Subject su:eCores)
            s+=su;

        s+="\n";

        s+=eMajor;

        s+="Electives: \n";
        for(Subject su:eElectives)
            s+=su;

        s+="Total Enrolled Credit: "+totalCredit+"pt\n";

        return s;
    }

    public String getCourseName(){
        return this.CNAME;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Record obj = (Record)super.clone();

        obj.eCores = new ArrayList<>();
        for(Subject s:this.eCores)
            obj.eCores.add((Subject)s.clone());

        obj.eMajor = (Major)this.eMajor.clone();

        obj.eElectives = new ArrayList<>();
        for(Subject s:this.eElectives)
            obj.eElectives.add((Subject)s.clone());

        return obj;
    }
}
