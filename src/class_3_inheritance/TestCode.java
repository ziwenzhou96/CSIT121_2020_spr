package class_3_inheritance;

public class TestCode {
    public static void main(String[] args) {
//        AlarmManagement am = new AlarmManagement();
//        am.addAlarmFromView();
//        am.displayAlarmView();
//
//        AlarmView av = new AlarmView();
//        String[] fields = av.userCreateAnAlarm();
//        for(String s:fields){
//            System.out.print(s+" ");
//        }
//        System.out.println();
//        int index = av.getAlarmIndex();
//        System.out.println(index);
//        av.displayAlarm("AlarmView tested");

        //test Timer class
        //test Constructor
        Timer t1 = new Timer(1);
        Timer t2 = new Timer(1,1);
        Timer t3 = new Timer(1,1,1);

        //test getter and setter
        System.out.println(t3.getHour()+":"+t3.getMintue()+":"+t3.getSecond());
        System.out.println("change 1:1:1 to 2:2:2 by setTimer(int,int,int)");
        t3.setTimer(2,2,2);
        System.out.println(t3);
        System.out.println("change 1:1:1 to 3:3:0 by setTimer(int,int)");
        t3.setTimer(3,3);
        System.out.println(t3);

    }
}
