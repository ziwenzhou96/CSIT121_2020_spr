package csci262;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IDSE {
    public static void main(String[] args) {
        try {
            int N;
            String line;
            String[] fields;

            Scanner in=new Scanner(Paths.get(args[0]));
            N=Integer.parseInt(in.nextLine());
            while(N>0&&in.hasNext()){
                line=in.nextLine();
                fields=line.split(":");
                for(int i=0;i<fields.length;i+=2){
                    new Event(fields[i],Double.parseDouble(fields[i+1]));
                    --N;
                }
            }
            in.close();

            in=new Scanner(Paths.get(args[1]));
            while(in.hasNext()){
                line=in.nextLine();
                fields=line.split(":");
                for(int i=0;i<fields.length;++i){
                    Event.events.get(i).dayRecord.add(Double.parseDouble(fields[i]));
                }
            }
            in.close();

            for(Event e:Event.events){
                e.calcAvgAndStd();
            }
            Event.calcThreshold();
            Event.print();

            in=new Scanner(Paths.get(args[2]));
            int lineCount=0;
            while(in.hasNext()){
                line=in.next();
                System.out.print("Line "+(++lineCount)+" -- "+line);
                fields=line.split(":");
                List<Double> today=new ArrayList<>();
                for(int i=0;i<fields.length;++i){
                    today.add(Double.parseDouble(fields[i]));
                }
                Event.calcDistance(today);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Event{
    String name;
    double weight,avg,std;
    List<Double> dayRecord;

    static List<Event> events=new ArrayList<>();
    static double THRESHOLD;

    public Event() {
        this.name = "";
        this.weight = 0;
        this.avg = 0;
        this.std = 0;
        this.dayRecord = new ArrayList<>();
    }

    public Event(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.avg = 0;
        this.std = 0;
        this.dayRecord = new ArrayList<>();
        Event.events.add(this);
    }

    public void calcAvgAndStd(){
        for(Double d:dayRecord){
            avg+=d;
        }
        avg/=dayRecord.size();

        for(Double d:dayRecord){
            std+=(avg-d)*(avg-d);
        }
        std/=dayRecord.size();
        std=Math.sqrt(std);
    }

    public static void calcThreshold() {
        for(Event e:events){
            Event.THRESHOLD+=e.weight;
        }
        Event.THRESHOLD*=2;
    }

    public static void calcDistance(List<Double> todayRecord) {
        double distance=0;

        for(int i=0;i<todayRecord.size();++i){
            distance+=Math.abs(todayRecord.get(i)-events.get(i).avg)/events.get(i).std*events.get(i).weight;
        }

        System.out.printf("\tDistance: %.2f\tAlarm:",distance);

        if(distance<Event.THRESHOLD){
            System.out.print("NO");
        }else{
            System.out.print("YES");
        }
        System.out.println();
    }

    public static void print() {
        System.out.printf("%-30s\t%10s\t%10s\t%10s\n","Event","Average","Stdev","Weight");
        for(Event e:events){
            System.out.printf("%-30s\t%10.2f\t%10.2f\t%10.2f\n",e.name,e.avg,e.std,e.weight);
        }
    }
}
