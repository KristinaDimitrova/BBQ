package main.utensils;

import main.utensils.requiredTypes.SaladTypes;

public class Bowl extends Utensil{

   private static final int CAPACITY = 5000;
   private int quantity = 0;
   private SaladTypes requiredType;


    public Bowl(SaladTypes requiredType) {
    this.requiredType = requiredType;
    }

    @Override
    public boolean isFull() {
        return quantity >= CAPACITY;
    }


    public SaladTypes getType() {
        return requiredType;
    }

    public synchronized void  addSalad(int qty){
        System.out.println("salad is added " + requiredType);
        quantity+=qty;
        notifyAll();
    }

    public boolean isEmpty(){
        return this.quantity <= 200;
    }

    public synchronized void takeSalad(){
        while (isEmpty()){
                try {
                   wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        this.quantity -=200;
    }
}
