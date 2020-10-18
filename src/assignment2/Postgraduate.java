package assignment2;

public class Postgraduate extends Student implements Cloneable{
    private String bachelorCompletion;
    private String masterCompletion;

    public Postgraduate() {
    }

    public Postgraduate(String name, int num, String g, String dob, String bachelorCompletion, String masterCompletion) {
        super(name, num, g, dob);
        this.bachelorCompletion = bachelorCompletion;
        this.masterCompletion = masterCompletion;
    }

    @Override
    public String toString() {
        String s = "";
        s += "----------------\n";
        s += super.toString();
        s += "Expected Master Graduation: "+masterCompletion+"\n\n";
        s += "Bachelor was received: "+bachelorCompletion+"\n";
        s += "----------------\n";
        return s;
    }

    @Override
    public void setExpectedCompletion(String expectedCompletion) {
        this.masterCompletion = expectedCompletion;
    }

    @Override
    public String getExpectedCompletion() {
        return this.masterCompletion;
    }

    public void setBachelorCompletion(String bachelorCompletion) {
        this.bachelorCompletion = bachelorCompletion;
    }

    public String getBachelorCompletion() {
        return this.bachelorCompletion;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
