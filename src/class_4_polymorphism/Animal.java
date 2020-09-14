package class_4_polymorphism;

import java.util.*;

public abstract class Animal {
    private int x,y;

    @Override
    public String toString() {
        return "Animal{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        list1.add(1);
//        list2.add(2);
//
//        Set<Integer> s1 = new HashSet<>();
//        Set<Integer> s2 = new TreeSet<>();

//        Animal a = new Animal(0,0);
//        Animal a;
        Fish f = new Fish(1,1);
        Bird b = new Bird(2,2);
        Frog fr = new Frog(3,3);
        Ant ant = new Ant(4,4);

//        Animal.st(a);
//        Animal.st(f);
//        Animal.st(b);
//        Animal.st(fr);
//        Animal.st(ant);

//        a.move();
//        f.move();
//        b.move();
//        fr.move();

        Animal[] animals = new Animal[5];
//        animals[0] = a;
        animals[1] = f;
        animals[2] = b;
        animals[3] = fr;
        animals[4] = ant;

        for(int i = 1; i < animals.length; ++i){
            System.out.println(i+": ");
            animals[i].move();
//            animals[i].speak();
//            animals[i].swim();
            if(animals[i] instanceof Ant){
                Ant a = (Ant)animals[i];
                a.speak();
            }

            if(animals[i] instanceof Fish){
                Fish a = (Fish)animals[i];
                a.swim();
            }

            animals[i].move();
            System.out.println(animals[i].getClass().getName());
        }
    }

    public static void st(Animal a) {
        System.out.println(a.toString()+"static method");
    }

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void move();
}


class Fish extends Animal{

    public Fish(int x, int y) {
        super(x, y);
    }

    public void move(){
        System.out.println("swim three feet");
    }

    public void swim() {
        System.out.println("swimming");
    }
}

class Bird extends Animal{

    public Bird(int x, int y) {
        super(x, y);
    }

    @Override
    public void move() {
        System.out.println("fly ten feet");
    }
}

class Frog extends Animal{

    public Frog(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(){
        System.out.println("jump five feet");
    }
}

class Bear extends Animal{

    public Bear(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(){
        System.out.println("walk six feet");
    }
}

abstract class Insect extends Animal{

    public Insect(int x, int y) {
        super(x, y);
    }

}

class Ant extends Insect{

    public Ant(int x, int y) {
        super(x, y);
    }

    @Override
    public void move() {
        System.out.println("slowly move");
    }

    public void speak (){
        System.out.println("hello");
    }

}


