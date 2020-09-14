package class_3_inheritance;

public class class_3_Inheritance {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Kison",12.4,3, Dog.DogType.D1),
                new Cat("Kitty",12.4,3, Cat.CatType.C1),
                new Bird("zhengshu",12.4,3, Bird.BirdType.B1),
                new Fish("Nimo",0.2,1)
        };

        Shop shop = new Shop(animals);

        shop.print();
    }

    public static void test1() {
//        class_3_Inheritance.Dog[] dogs = {
//                new class_3_Inheritance.Dog("Momo",12.3,3, class_3_Inheritance.Dog.DogType.D1),
//                new class_3_Inheritance.Dog("D",12.3,4, class_3_Inheritance.Dog.DogType.D2),
//                new class_3_Inheritance.Dog("P",12.3,4, class_3_Inheritance.Dog.DogType.D3),
//                new class_3_Inheritance.Dog("Kison",12.3,5, class_3_Inheritance.Dog.DogType.D3)
//        };
//
//        class_3_Inheritance.Cat[] cats = {
//                new class_3_Inheritance.Cat("Tang",6.3,3, class_3_Inheritance.Cat.CatType.C1),
//                new class_3_Inheritance.Cat("Tc",4.3,4, class_3_Inheritance.Cat.CatType.C2),
//                new class_3_Inheritance.Cat("sdf",8.3,4, class_3_Inheritance.Cat.CatType.C2),
//                new class_3_Inheritance.Cat("zhengshu",9.3,5, class_3_Inheritance.Cat.CatType.C3)
//        };
//
//        class_3_Inheritance.Shop shop = new class_3_Inheritance.Shop(dogs,cats);
//        shop.print();
    }

    public static void test2(){
        Dog d = new Dog("Kison",12.5,24,Dog.DogType.D1);

        System.out.println(d.toString());
        d.sound();

        Cat c = new Cat("Miao",12.5,24,Cat.CatType.C1);

        System.out.println(c.toString());
        c.sound();
    }
}


class Shop{
//    public class_3_Inheritance.Dog[] dogs;
//    public class_3_Inheritance.Cat[] cats;

    public Animal[] animals;

//    public class_3_Inheritance.Shop(class_3_Inheritance.Dog[] dogs, class_3_Inheritance.Cat[] cats) {
//        this.dogs = dogs;
//        this.cats = cats;
//    }

    public Shop(Animal[] animals) {
        this.animals = animals;
    }

    public void print(){
//        for(class_3_Inheritance.Dog d:dogs){
//            System.out.println(d.toString());
//        }
//
//        for(class_3_Inheritance.Cat c:cats){
//            System.out.println(c.toString());
//        }
        for(Animal a:animals){
            System.out.println(a.toString());
        }
    }
}

class Animal{
    private String name;
    private double weight;
    private int age;

    public Animal(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void sound(){
        System.out.println("class_3_Inheritance.Animal sound");
    }

    @Override
    public String toString() {
        return "class_3_Inheritance.Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}

class Dog extends Animal{
    private DogType type;

    enum DogType{
        D1,D2,D3,D4;
    }

    public Dog(String name, double weight, int age, DogType type) {
        super(name,weight,age);
        this.type = type;
    }

    @Override
    public void sound() {
        System.out.println("woof woof");
    }

    @Override
    public String toString() {
        return "class_3_Inheritance.Dog{" +
                "type=" + type +
                ", " + super.toString()+
                '}';
    }
}

//class class_3_Inheritance.Dog extends class_3_Inheritance.Animal{
//    String name;
//    double weight;
//    int age;
//    DogType type;
//
//    enum DogType{
//        D1,D2,D3,D4;
//    }
//
//    public class_3_Inheritance.Dog(String name, double weight, int age, DogType type) {
//        this.name = name;
//        this.weight = weight;
//        this.age = age;
//        this.type = type;
//    }
//
//    @Override
//    public String toString() {
//        return "class_3_Inheritance.Dog{" +
//                "name='" + name + '\'' +
//                ", weight=" + weight +
//                ", age=" + age +
//                ", type=" + type +
//                '}';
//    }
//}

class Cat extends Animal{
    CatType type;

    enum CatType{
        C1,C2,C3;
    }

    public Cat(String name, double weight, int age, CatType type) {
        super(name,weight,age);
        this.type = type;
    }

    @Override
    public void sound() {
        System.out.println("Miao miao");
    }

    @Override
    public String toString() {
        return "class_3_Inheritance.Cat{" +
                "type=" + type +
                ", " + super.toString() +
                '}';
    }
}

class Bird extends Animal{
    BirdType type;

    public Bird(String name, double weight, int age, BirdType type) {
        super(name, weight, age);
        this.type = type;
    }

    enum BirdType{
        B1,B2,B3
    }

    @Override
    public void sound() {
        System.out.println("Ji Ji");
    }


    @Override
    public String toString() {
        return "class_3_Inheritance.Bird{" +
                "type=" + type +
                ", " + super.toString() +
                '}';
    }
}

class Fish extends Animal{

    public Fish(String name, double weight, int age) {
        super(name, weight, age);
    }
}
