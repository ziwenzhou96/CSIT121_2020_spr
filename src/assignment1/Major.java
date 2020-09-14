package assignment1;

public class Major {
    private String name;
    private Subject[] subjects;

    public Major(String name) {
        this.name = name;
    }

    public void addMCores(Subject[] subjects){
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public boolean containSubject(String code){
        for(Subject sub:this.subjects){
            if(sub.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public int getTotalCreditPoints(){
        int points = 0;
        for(Subject s:subjects){
            points += s.getPoint();
        }
        return points;
    }

    public String toString(){
        String result = this.name+" Major";
        for(Subject s:subjects){
            result += "\n"+s.toString();
        }
        return result;
    }
}
