package assignment2;

public class Undergraduate extends Student implements Cloneable{
    private String bachelorCompletion;

    public Undergraduate() {
        super();
    }

    public Undergraduate(String name, int num, String g, String dob, String bachelorCompletion) {
        super(name, num, g, dob);
        this.bachelorCompletion = bachelorCompletion;
    }

    @Override
    public String toString() {
        String s = "";
        s += "----------------\n";
        s += super.toString();
        s += "Expected Bachelor Graduation: "+bachelorCompletion+"\n";
        s += "----------------\n";
        return s;
    }

    @Override
    public void setExpectedCompletion(String expectedCompletion) {
        this.bachelorCompletion = expectedCompletion;
    }

    @Override
    public String getExpectedCompletion() {
        return this.bachelorCompletion;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
