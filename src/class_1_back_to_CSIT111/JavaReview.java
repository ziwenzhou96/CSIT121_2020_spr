package class_1_back_to_CSIT111;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaReview {
    public static void main(String[] args) {
        test5();
    }
    //• Variables
    public static void test1() {

        int a = 10;
        int b = a;
        b = 11;
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        String[] a1 = {"usyd","uow"};
        int[] a2 = new int[5];
//        a1[0] = 10;
        String s = "uow";
        System.out.println(s.toUpperCase());
        System.out.println("a1:"+a1[0].toUpperCase());
        System.out.println("a2:"+a2[0]);
    }
    //• Primitive types
    public static void test2() {
        int b = 10;
        int c = 3;
        double a = b/(double)c;
        System.out.println(a);
        System.out.println((int)Math.pow(10,4));
        System.out.println((double)b);
    }
    //• Array & ArrayList
    public static void test3() {
        int[] a1 = new int[]{1,3,2,4};
        System.out.println(a1[1]);
        char[] a2 = new char[5];
        System.out.println("\""+a2[0]+"\"");
        a2[2] = 'a';
        a2[3] = 65;
        System.out.println(a2.length);
        testArray(a2);
        System.out.println((int)'A');

        List<Integer> list1 = new ArrayList<>();
        System.out.println("list size: "+list1.size());
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }

        System.out.println("list size: "+list1.size());
        System.out.println("2nd element: "+list1.get(1));
        list1.remove(1);
        System.out.println("2nd element: "+list1.get(1));
        System.out.println("list size: "+list1.size());

        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }

        list1.forEach(System.out::println);

        System.out.println(list1);

        List<Integer> list2 = new LinkedList<>();
    }

    public static char[] testArray(char[] array) {
        for(int i = 0; i < array.length; i++){
            System.out.println(i+": "+array[i]);
        }
        return array;
    }
    //• String & Char
    public static void test4() {
        String s = "Kisons2n";
        System.out.println(s.equals("Kison"));
        System.out.println(s.equals("kison"));
        System.out.println(s.compareTo("Simon"));
        System.out.println(s.compareToIgnoreCase("kison"));
        System.out.println(s.length());
        System.out.println(s.charAt(1));
        System.out.println("index of: "+s.indexOf("son"));
        System.out.println("substring: "+s.substring(4));
        System.out.println("substring: "+s.substring(4,6));
        System.out.println("startsWith: "+s.startsWith("Ki"));
        System.out.println("endsWith: "+s.endsWith("on"));
        System.out.println("contains: "+s.contains("s2on"));
        System.out.println("matches: "+s.matches("^Ki.*"));
        System.out.println("matches: "+s.matches(".*on$"));
        System.out.println("matches: "+s.matches(".*son.*"));
        System.out.println("matches: "+s.matches("[A-Za-z0-9]{8}"));
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(1+1);
        System.out.println(1+" "+1);

        System.out.println("abc"+(char)('a'+1)+"abc");
    }
    //• Arithmetic operators & precedence
    public static void test5() {

        System.out.println("Grade:" + (85 + 21.4) / 2);
            int a = 10;
        System.out.println((double)a++);
        System.out.println(a);
        a = 10;
        System.out.println((double)++a);
        System.out.println(a);
    }
    //• Logical operators & relational expression
    public static void test6() {

    }
    //• Selection statement
    //• Repetition statement
    //• Method, passing parameter and return
    //• Predefined java class

}
