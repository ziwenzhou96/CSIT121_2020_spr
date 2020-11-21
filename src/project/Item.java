package project;

public class Item {
    private Food food;
    private int quantity;
    private double totalPrice;

    public Item(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = food.getPrice()*quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity){
        this.quantity+=quantity;
    }

    @Override
    public String toString() {
        String result=String.format("%-24s\t\tQuantity:%-3d\t$%-10.1f\t",this.food.getName(),this.quantity,this.totalPrice);
        if(food.isVegetarian())
            result+="Vegetarian";
        return result;
    }
}
