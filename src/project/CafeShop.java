package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class CafeShop {
    private CafeOrderWindow cafeOrderWindow;
    private Order order;
    private Map<String,List<Food>> foodCategoryMap;
    private Map<String,Food> foodNameMap;

    public CafeShop() {
        this.order=new Order();
        this.foodCategoryMap=new HashMap<>();
        this.foodNameMap=new HashMap<>();
        this.createTestData();
        this.cafeOrderWindow=new CafeOrderWindow(this);
    }

    public void createTestData(){
        List<Food> pizzas=new ArrayList<>();
        Food p1=new Food(foodNameMap, "Tropicana Pizza","Ham...",10.0);
        Food p2=new Food(foodNameMap, "Tropicana Pizza (NM)","Ham...",13.0);
        Food p3=new VegetarianFood(foodNameMap, "Garlic Pizza","Confit...",8.0);
        Food p4=new VegetarianFood(foodNameMap, "Garlic Pizza (NM)","Confit...",11.0);
        pizzas.add(p1);
        pizzas.add(p2);
        pizzas.add(p3);
        pizzas.add(p4);
        this.foodCategoryMap.put("Pizza",pizzas);

        List<Food> buggers=new ArrayList<>();
        Food b1=new Food(foodNameMap, "Wagyu Burger","Wagyu...",16.5);
        Food b2=new Food(foodNameMap, "Wagyu Burger (NM)","Wagyu...",19.5);
        Food b3=new VegetarianFood(foodNameMap, "Halloumi Burger","Milk...",10.0);
        Food b4=new VegetarianFood(foodNameMap, "Halloumi Burger (NM)","Milk...",13.0);
        buggers.add(b1);
        buggers.add(b2);
        buggers.add(b3);
        buggers.add(b4);
        this.foodCategoryMap.put("Burgers",buggers);

        List<Food> sides=new ArrayList<>();
        Food s1=new VegetarianFood(foodNameMap, "Sweet Potato Fries (Bowl)","Served...",6.5);
        Food s2=new VegetarianFood(foodNameMap, "Sweet Potato Fries (Bowl) (NM)","Served...",9.5);
        Food s3=new VegetarianFood(foodNameMap, "Chips (Bowl)","Served...",5.0);
        Food s4=new VegetarianFood(foodNameMap, "Chips (Bowl) (NM)","Served...",8.0);
        sides.add(s1);
        sides.add(s2);
        sides.add(s3);
        sides.add(s4);
        this.foodCategoryMap.put("Sides",sides);
    }

    public Map<String,List<Food>> getFoodCategoryMap(){
        return this.foodCategoryMap;
    }

    public Order getOrder() {
        return order;
    }

    public List<Food> getFoodListByCategory(String category) {
        return this.foodCategoryMap.get(category);
    }

    public Food getFoodByName(String name) {
        return this.foodNameMap.get(name);
    }

    public void addFood(Food food,int quantity){
        this.order.addItem(food,quantity);
    }

    public void clearOrder(){
        this.order=new Order();
    }

    public void saveOrder(String customerName,int id){
        if(customerName.trim().isEmpty()) throw new InputMismatchException("The customer name cannot be empty.");
        if(id<0) throw new InputMismatchException("The table id cannot be negative number:"+id);

        String fileName=customerName+"_"+id+".txt";
        Formatter out=null;
        try {
            out=new Formatter(new File(fileName));
            out.format("Customer Name: %s; Table ID: %n",customerName,id);
            out.format(order.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(out!=null)
                out.close();
            out=null;
        }
    }
}
