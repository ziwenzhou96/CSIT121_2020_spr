import org.jetbrains.annotations.NotNull;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class class_10_review {
    public static void main(String[] args) {
        int a = 10;
        Integer b = 10;
        Iterator<Integer> itr;

//        List<Integer> list=new ArrayList<>();
//
//        list.add(2);
//        list.add(4);
//        list.add(3);
//        list.add(5);
//        list.add(7);

//        Collections.sort(list, (o1, o2) -> {
//            return (o1<o2)?-1:(o1>o2)?1:0;
////            if(o1<o2){
////                return -1;
////            }else if(o2<o1){
////                return 1;
////            }
////            return 0;
//        });
//        Collections.sort(list,(o1,o2)->(o1<o2)?-1:(o1>o2)?1:0);

//        for(int i:list){
//            System.out.print(i+" ");
//        }

        List<Student> stlist=new LinkedList<>();
        stlist.add(new Student("aaa",18));
        stlist.add(new Student("aaa",13));
        stlist.add(new Student("aaa",15));
        stlist.add(new Student("bb",16));
        stlist.add(new Student("abb",18));

        Collections.sort(stlist,new STNameComparator());
        stlist.forEach(System.out::println);

        System.out.println();

        Collections.sort(stlist,new STAgeComparator());

//        stlist.forEach(new PrintFun());
        stlist.forEach(s->{
            System.out.println("I am "+s.name+", my age is "+s.age+".");
        });

        Data<Student> st=new Data<>();
        try {
            System.out.println(st.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Student a1=new Student("",1);
        a1=new Student("a",2);
    }
}

class PrintFun implements Consumer<Student>{

    @Override
    public void accept(Student student) {
        System.out.println("I am "+student.name+", my age is "+student.age+".");
    }
}

class STNameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class STAgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.age<o2.age)?-1:(o1.age>o2.age)?1:0;
    }
}

class Student implements Comparable<Student>{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        if(this.name.equals(o.name)){
            return (this.age<o.age)?-1:(this.age>o.age)?1:0;
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Data<DataType>{
    DataType value;

    public DataType getValue() throws Exception {
        if(value==null){
            throw new Exception("data is empty.");
        }
        return value;
    }

    public void setValue(DataType value) {
        this.value = value;
    }

    public boolean isEmpty(){
        return value==null;
    }
}