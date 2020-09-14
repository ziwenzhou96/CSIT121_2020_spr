package assignment1;

public class Course {
    private String name;
    private Subject[] cCores;
    private Subject[] cEles;
    private Major[] BCSMajors;
    public static final int MINIMAL_CREDIT_POINTS_REQUIREMENT = 144;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCores(Subject[] cCores) {
        this.cCores = cCores;
    }

    public void addElectives(Subject[] cEles) {
        this.cEles = cEles;
    }

    public void addMajors(Major[] BCSMajors) {
        this.BCSMajors = BCSMajors;
    }

    public Subject[] getcCores() {
        return cCores;
    }

    public int getCoreTotalCreditPoints(){
        int points = 0;
        for(Subject s:cCores){
            points += s.getPoint();
        }
        return points;
    }

    public String getMajorList(){
        String result = "";
        for(int i = 0; i < BCSMajors.length; ++i){
            result+=(i+1)+": "+BCSMajors[i].getName()+"\n";
        }
        return result;
    }

    public Major getMajor(int index){
        return BCSMajors[index];
    }

    public Subject[] getcEles() {
        return cEles;
    }

    public String toString(){
        String result = "Course: "+this.name+"\n";

        result += "\nCore Subjects:\n";
        for(Subject s:cCores){
            result += s.toString()+"\n";
        }

        for(Major m:BCSMajors){
            result += "\n"+m.toString()+"\n";
        }

        result += "\nElective Subjects:";
        for(Subject s:cEles){
            result += "\n"+s.toString();
        }

        return result;
    }
}
