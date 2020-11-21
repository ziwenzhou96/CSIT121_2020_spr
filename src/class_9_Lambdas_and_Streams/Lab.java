package class_9_Lambdas_and_Streams;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lab {
    public static void main(String[] args) {
//        System.out.println("Q1");
//        Q1();
//
//        System.out.println("Q2");
//        Q2();

//        System.out.println("Q3");
//        Q3();

        System.out.println("Q4");
        Q4();
    }

    public static void Q1() {
        int[] values={12,2,9,8,4,65,7,4,2,66,88,11,33,44,55};
        double result = 0;
        for(int e : values) {
            result = result +e;
        }
        result=result/values.length;

        System.out.println(result);
        System.out.println(IntStream.of(values).average().getAsDouble());

//        List<double[]> list = new ArrayList<>();
//        IntStream.of(values).forEach(x->list.add(new double[]{x,1}));
//        double[] res = list.stream().reduce(new double[]{0,0},(x,y)->{
//            x[0]+=y[0];
//            x[1]+=y[1];
//            return x;
//        });
//        System.out.println(res[0]/res[1]);
    }

    public static void Q2() {
        Integer[] values={12,2,9,8,4,65,7,4,2,66,88,11,33,44,55};
        Set<Integer> a = new TreeSet<>(Arrays.asList(values));
        for(int e : a) {
            System.out.println(e);
        }

        System.out.println();
        Arrays.stream(values).distinct().sorted().forEach(System.out::println);
    }

    public static void Q3() {
        CarEngine a0 = new CarEngine("Honda GT",2500,6,"98");
        CarEngine a1 = new CarEngine("Hyundai XTX",2100,6,"98");
        CarEngine a2 = new CarEngine("Holden TT",1200,6,"98");
        CarEngine a3 = new CarEngine("Toyota TX",900,6,"98");
        CarEngine a4 = new CarEngine("Tesla GX",0,0,"Electricity");

        Map<String,CarEngine> ma = new HashMap<>();
        ma.put(a0.getEngineName(),a0);
        ma.put(a1.getEngineName(),a1);
        ma.put(a2.getEngineName(),a2);
        ma.put(a3.getEngineName(),a3);
        ma.put(a4.getEngineName(),a4);

        System.out.print("Please enter engine name: ");
        Scanner sc = new Scanner(System.in);
        String engineName = sc.nextLine();
        System.out.print("Result: ");
        ma.values().stream().filter(x->x.getEngineName().equals(engineName)).forEach(System.out::println);//convert a hashmap to a stream.
        System.out.println();
        System.out.println("The engine that the cylinder volume between 1000 cc. to 2400 cc.: ");
        ma.values().stream().filter(x->x.getCylinderVolumn()>=1000&&x.getCylinderVolumn()<=2400).forEach(System.out::println);
    }

    public static void Q4(){
        System.out.print("Input: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Output:");
        solve(n,'A','B','C');
    }

    public static void solve(int n, char start, char temp, char end) {
        if(n==0) return;
        solve(n-1,start,end,temp);
        System.out.println("\tDisk "+n+" moved from "+start+" to "+end);
        solve(n-1,temp,start,end);
    }
}
