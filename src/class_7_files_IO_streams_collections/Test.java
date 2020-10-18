package class_7_files_IO_streams_collections;


import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        outputObject();
        inputObject();
    }

    public static void test(){
//        sScanner input = new Scanner(System.in);
//        String line = input.nextLine();
//        System.out.println("Your have input:"+line);
        String fileName = "src";

        Path path = Paths.get(fileName);

        if(Files.exists(path)){
            try {
                System.out.println(path.getFileName());
                System.out.println("Is directory: "+Files.isDirectory(path));
                System.out.println("Is absolute: "+path.isAbsolute());
                System.out.println("Size: "+Files.size(path));
                System.out.println("Path: "+path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(Files.isDirectory(path)){
            try {
                DirectoryStream<Path> directoryStream =
                        Files.newDirectoryStream(path);
                for(Path p:directoryStream){
                    System.out.println(p);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        System.out.println(fileName);
//        System.out.println(path.toUri().getPath());
    }

    public static void writeFile() {
        try {
            Formatter formatter = new Formatter("mytest.txt");
            formatter.format("%s %d %.4f","Hello",1,15.23426);
            formatter.flush();
            formatter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            Scanner sc = new Scanner(Paths.get("mytest.txt"));
            while (sc.hasNext()){
                String str = sc.nextLine();
                System.out.println("word:"+str);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputObject(){
        Address address = new Address("street","NSW","2500");
        Student holly = new Student("holly",15,address);
        try {
            ObjectOutputStream ops = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get("student.ser"))
            );
            ops.writeObject(holly);
            ops.writeObject(holly);
            ops.writeObject(holly);
            ops.flush();
            ops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputObject(){
        Student holly;

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    Files.newInputStream(Paths.get("student.ser"))
            );
            while ((holly=(Student)ois.readObject()) != null) {
                System.out.println(holly);
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {
    static final long serialVersionUID = 43L;
    String name;
    int age;
    Address address;

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

class Address implements Serializable  {
    static final long serialVersionUID = 42L;
    String street,state,postcode;

    public Address(String street, String state, String postcode) {
        this.street = street;
        this.state = state;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}