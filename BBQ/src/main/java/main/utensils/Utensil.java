package main.utensils;

public abstract class Utensil {
    private double itemsPrice;

    public abstract boolean isFull();

    public  void setItemsPrice(double itemsPrice){
        this.itemsPrice += itemsPrice;
    }
    public  double getItemsPrice(){
        return itemsPrice;
    }
}

