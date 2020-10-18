package class_5_interface;

public class Test {
    public static void main(String[] args) {
        MyStudent[] myStudents = new MyStudent[4];
        myStudents[0] = new Kison();
        myStudents[1] = new Holly();
        myStudents[2] = new DK();
        myStudents[3] = new Eric();

        MyStudent[] students2 = myStudents;
        myStudents[1] = new DK();

        for(MyStudent st: myStudents){
            if(st instanceof KisonAble){
                KisonAble ka = (KisonAble) st;
                ka.eat();
            }

            if(st instanceof StudyAble){
                StudyAble sa = (StudyAble) st;
                sa.study();
            }

            System.out.println();
        }
    }

}


class Holly extends MyStudent implements KisonAble, StudyAble{

    @Override
    public void eat() {
        System.out.println("ba ji ba ji");
    }

    @Override
    public void study() {
        System.out.println("so hard");
    }
}

class Kison extends MyStudent implements KisonAble{

    @Override
    public void eat() {
        System.out.println("ao wu ao wu");
    }

    @Override
    public void study() {
        System.out.println("help me");
    }
}

class DK extends MyStudent implements StudyAble, KisonAble{

    @Override
    public void study() {
        System.out.println("so easy");
    }
}

class Eric extends MyStudent implements StudyAble, KisonAble{

    @Override
    public void study() {
        System.out.println("not bad");
    }
}

abstract class MyStudent implements StudyAble{

}

interface KisonAble{
    public static final int count = 0;

    public default void eat(){
        System.out.println("hu lu hu lu");
    }
}

interface StudyAble{
    public abstract void study();
}