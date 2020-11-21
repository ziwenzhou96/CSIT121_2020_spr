package project;

import java.util.Map;

public class VegetarianFood extends Food {
    public VegetarianFood(Map<String, Food> foodNameMap, String name, String dest, double price) {
        super(foodNameMap, name, dest, price);
    }

    public boolean isVegetarian() {
        return true;
    }
}
