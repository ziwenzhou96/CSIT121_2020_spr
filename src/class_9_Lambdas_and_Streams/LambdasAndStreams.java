package class_9_Lambdas_and_Streams;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdasAndStreams {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("Holly");
//        list.add("Kison");
//        list.add("Yellow fish");
//
//        for(String x:list){
//            System.out.println("Hello,"+x+"!");
//        }
//
//        list.forEach(System.out::println);

        int N = 300000;
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int sum = 0;
        for(int i=0; i<10; i++){
            sum+=Math.sqrt(arr[i]);
        }
        System.out.println(sum);

        System.out.println(IntStream.of(arr).sum());

        System.out.println(IntStream.of(arr).reduce(0,(x,y)->(int)Math.sqrt(x+y)));

        IntStream.of(arr).map(x->x*101).filter(x->x%2==0).forEach(System.out::println);

    }
}

interface Function1{
    int run(int a,int b);
}

interface Function2{
    double run(double a,double b);
}
