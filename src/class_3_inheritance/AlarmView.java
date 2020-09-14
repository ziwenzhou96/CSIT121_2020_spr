package class_3_inheritance;

import java.util.Scanner;

public class AlarmView {
    public AlarmView() {

    }

    public String[] userCreateAnAlarm(){
        Scanner in = new Scanner(System.in);
        String[] result = new String[3];

        //method 1
        System.out.print("Please enter Alarm name: ");
        result[0] = in.next();

        System.out.print("Please enter Hour: ");
        result[1] = in.next();

        System.out.print("Please enter Mintue: ");
        result[2] = in.next();

        //method 2
//        System.out.print("Please enter Name Hour Mintue: ");
//        String line= in.nextLine();
//        result = line.split(" ");

        return result;
    }

    public int getAlarmIndex(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter Alarm Index: " );
        int result = in.nextInt();
        return result;
    }

    public void displayAlarm(String text){
        System.out.println(text);
    }
}
