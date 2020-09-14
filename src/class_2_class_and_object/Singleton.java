package class_2_class_and_object;

import org.jetbrains.annotations.Contract;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if(singleton==null){
            singleton = new Singleton();
        }
        return Singleton.singleton;
    }
}
