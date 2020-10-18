package class_5_interface;

import java.text.*;
import java.util.Date;

public class Lab {
    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        PostCode pc1 = new PostCode("Wollongong","Wollongong",State.ACT,2500);
        Address a1 = new Address("12","page street","Australia",pc1);

        PostCode pc2 = pc1;
        Address a2 = new Address("85","kison street","Australia",pc2);

        System.out.println(a1);
        System.out.println(a2);

        pc1.setPostCode(1000);

        System.out.println("Shallow clone");
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Deep clone by copy constructor");
        pc2 = new PostCode(pc1);
        a2.setPostCode(pc2 );
        pc1.setPostCode(2500);

        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Deep clone by Cloneable");
        pc2 = pc1.clone();

        a2.setPostCode(pc2);
        pc1.setPostCode(4500);

        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Address deep clone");
        Address a3 = new Address("12","page street","Australia",
                new PostCode("Wollongong","Wollongong",State.ACT,2500));
        Address a4 = a3.clone();

        a3.setAddressName("changed street");
        a3.getPostCode().setCity("changed city");
        a3.getPostCode().setPostCode(8000);

        System.out.println(a3);
        System.out.println(a4);

//        UnderGrand ug = new UnderGrand(false);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(df.format(new Date()));
        String dateStr = "01/003/1999";
        Date date = df.parse(dateStr);
        System.out.println(df.format(date));

        PostGrad pg = new PostGrad("00001","Kison","Wu","1996324234",
                43432587,a3,"CS",date);
    }
}

class Address implements Cloneable{
    private String addressNum, addressName, country;
    private PostCode postCode;

    public Address(String addressNum, String addressName, String country, PostCode postCode) {
        this.addressNum = addressNum;
        this.addressName = addressName;
        this.country = country;
        this.postCode = postCode;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        Address obj = (Address)super.clone();
        obj.postCode = (PostCode) this.postCode.clone();
        return obj;
    }

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PostCode getPostCode() {
        return postCode;
    }

    public void setPostCode(PostCode postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
//        return addressNum + " " + addressName + " " + country + " " + postCode.toString();

        return  "addressNum='" + addressNum + '\'' +
                ", addressName='" + addressName + '\'' +
                ", country='" + country + '\'' +
                ", postCode=" + postCode.toString();
    }
}

class PostCode implements Cloneable{
    private String suburb, city;
    private State state;
    private int postCode;

    public PostCode(String suburb, String city, State state, int postCode) {
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public PostCode(PostCode other) {
        this.suburb = other.suburb;
        this.city = other.city;
        this.state = other.state;
        this.postCode = other.postCode;
    }

    @Override
    protected PostCode clone() throws CloneNotSupportedException {
        return (PostCode) super.clone();
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", postCode=" + postCode;
    }


}

enum State{
    NSW,ACT,QLD,WA,VIC,SA,NT,TAS;
}

class UnderGrand{
    boolean domestic;

    public UnderGrand(boolean domestic) {
        this.domestic = domestic;
    }

    @Override
    public String toString() {
        return "UnderGrand{" +
                "domestic=" + domestic +
                '}';
    }
}

interface UNIAccountInfo{
    public abstract String getFirstName();
    public abstract String getLsatName();
    public abstract String getContactInfo();
    public abstract String getID();
}

abstract class Student implements UNIAccountInfo{
    private String stuID,fname,lname,idNum;
    private int mobile;
    private Address address;

    public Student(String stuID, String fname, String lname, String idNum, int mobile, Address address) {
        this.stuID = stuID;
        this.fname = fname;
        this.lname = lname;
        this.idNum = idNum;
        this.mobile = mobile;
        this.address = address;
    }

    //get and set method

    @Override
    public String toString() {
        return  "stuID='" + stuID + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", idNum='" + idNum + '\'' +
                ", mobile=" + mobile +
                ", address=" + address.toString();
    }

    @Override
    public String getFirstName() {
        return this.fname;
    }

    @Override
    public String getLsatName() {
        return this.lname;
    }

    @Override
    public String getContactInfo() {
        return "mobile: "+this.mobile+"\nAddress: "+this.address.toString();
    }

    @Override
    public String getID() {
        return this.stuID;
    }
}

class Alumni implements UNIAccountInfo{
    private String ID,fname,lname,email;

    public Alumni(String ID, String fname, String lname, String email) {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    @Override
    public String toString() {
        return  "ID='" + ID + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'';
    }

    @Override
    public String getFirstName() {
        return this.fname;
    }

    @Override
    public String getLsatName() {
        return this.lname;
    }

    @Override
    public String getContactInfo() {
        return "Email: "+this.email;
    }

    @Override
    public String getID() {
        return this.ID;
    }
}

class PostGrad extends Student{
    private String BSDegree;
    private Date BSCompletionDate;

    public PostGrad(String stuID, String fname, String lname, String idNum, int mobile, Address address, String BSDegree, Date BSCompletionDate) {
        super(stuID, fname, lname, idNum, mobile, address);
        this.BSDegree = BSDegree;
        this.BSCompletionDate = BSCompletionDate;
    }
}
