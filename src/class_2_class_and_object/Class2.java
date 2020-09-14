package class_2_class_and_object;

public class Class2 {
    Student st;
    public static void main(String[] args) {
//        Singleton s = new Singleton();
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
    }

    public void test() {
//        st = new Student();
//        System.out.println(st.getName());
//        st.setName("Iris");
//        System.out.println(st.getName());
//
//        Student st2 = new Student();
//        System.out.println(st2.getName());
//        st2.setName("Simon");
//        System.out.println(st2.getName());
    }
}
