package class_5_interface;

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Kison();
        students[1] = new Holly();
        students[2] = new DK();
        students[3] = new Eric();

        Student[] students2 = students;
        students[1] = new DK();

        for(Student st:students){
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


class Holly extends Student implements KisonAble, StudyAble{

    @Override
    public void eat() {
        System.out.println("ba ji ba ji");
    }

    @Override
    public void study() {
        System.out.println("so hard");
    }
}

class Kison extends Student implements KisonAble{

    @Override
    public void eat() {
        System.out.println("ao wu ao wu");
    }

    @Override
    public void study() {
        System.out.println("help me");
    }
}

class DK extends Student implements StudyAble, KisonAble{

    @Override
    public void study() {
        System.out.println("so easy");
    }
}

class Eric extends Student implements StudyAble, KisonAble{

    @Override
    public void study() {
        System.out.println("not bad");
    }
}

abstract class Student implements StudyAble{

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