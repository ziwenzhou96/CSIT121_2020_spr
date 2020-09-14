package class_3_inheritance;

import java.util.ArrayList;

public class AlarmManagement {
    ArrayList<Alarm> alarms;
    AlarmView view;

    public AlarmManagement() {
        this.alarms = new ArrayList<Alarm>();
        this.view = new AlarmView();
    }

    public void addAlarm(Alarm alarm){
        this.alarms.add(alarm);
    }

    public Alarm getAlarmAt(int index){
        return alarms.get(index);
    }

    public void addAlarmFromView(){
        String[] fields = view.userCreateAnAlarm();
        try {
            Alarm a = new Alarm(fields[0],Integer.parseInt(fields[1]),Integer.parseInt(fields[2]));
            this.addAlarm(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayAlarmView(){
        int index = view.getAlarmIndex();
        Alarm a = this.getAlarmAt(index);
        view.displayAlarm(a.toString());

//        view.displayAlarm(this.getAlarmAt(view.getAlarmIndex()).toString());
    }
}
