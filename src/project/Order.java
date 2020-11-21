package project;

import java.util.*;

public class Order {
    private List<Item> shoppingList;
    private Map<String,Item> shoppingMap;
    private double totalPrict;
//    private String customerName;
//    private int id;

    public Order() {
        this.shoppingList=new ArrayList<>();
        this.shoppingMap=new HashMap<>();
        this.totalPrict=0;
//        this.customerName="Empty Name";
//        this.id=-1;
    }

    public void addItem(Food food, int quantity){
        if(quantity<=0){
            throw new InputMismatchException("The quantity must greater than zero:"+quantity);
        }
        if(this.shoppingMap.containsKey(food.getName())){
            this.shoppingMap.get(food.getName()).addQuantity(quantity);
        }else{
            Item newItem=new Item(food,quantity);
            this.shoppingList.add(newItem);
            this.shoppingMap.put(food.getName(),newItem);
        }
        totalPrict+=food.getPrice()*quantity;
    }

//    public String toStringForSavingFile() {
//        String result=String.format("Customer Name: %s; Table ID: %n",this.customerName,this.id);
//        result+=this.toString();
//        return result;
//    }

    @Override
    public String toString() {
        String result="";
        for(Item item:shoppingList)
            result+=item.toString()+"\n";
        result+="\n----------------------\n";
        result+=String.format("Total Price: $%.1f",this.totalPrict);
        return result;
    }
}
