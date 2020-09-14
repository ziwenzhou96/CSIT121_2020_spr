package class_4_polymorphism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyCollection c = new MyCollection();
        MyCollection l1 = new MyList();
        MyList l2 = new MyList();
//        MyList l3 = (MyList)c;

        c.add(1);
        l1.add(1);// A.MyList... B.MyCollection...
        l2.add(1);

//        ((MyList)c).add(1);// A.no error B error
        ((MyCollection)l2).add(1);// A.no error B error
        System.out.println("a");
        System.out.println('a');
        System.out.println(1);
        System.out.println(l1);
    }
}

class MyCollection{
    private List<Integer> data;

    public MyCollection() {
        this.data = new ArrayList<>();
    }

    public void add(Integer o){
        System.out.println("MyCollection add new item");
    }

    public void remove(Integer o){
        System.out.println("MyCollection remove item");
    }
}

class MyList extends MyCollection {
    public void add(Integer o){
        System.out.println("MyList add new item");
    }

    public void remove(Integer o){
        System.out.println("MyList remove item");
    }
}

class MySet extends MyCollection {
    public void add(Integer o){
        System.out.println("MySet add new item");
    }

    public void remove(Integer o){
        System.out.println("MySet remove item");
    }
}


