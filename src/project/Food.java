package project;

import java.util.Map;

public class Food {
    private String name;
    private String dest;
    private double price;

    public Food(Map<String, Food> foodNameMap, String name, String dest, double price) {
        this.name = name;
        this.dest = dest;
        this.price = price;
        foodNameMap.put(this.name,this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%-24s\t\t$%.1f",this.name,this.price);
    }

    public int length(){
        return this.toString().length();
    }
}
