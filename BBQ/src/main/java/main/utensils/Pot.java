package main.utensils;

import main.foods.meat.Meat;
import main.utensils.requiredTypes.MeatTypes;

import java.util.LinkedList;
import java.util.Queue;

public class Pot extends Utensil {

    private Queue<Meat> meats;
    private static final int CAPACITY = 20;
    private MeatTypes requiredType;

    public Pot(MeatTypes requiredType) {
        this.requiredType = requiredType;
        meats= new LinkedList<>();
    }

    @Override
    public boolean isFull() {
        return meats.size()>=CAPACITY;
    }


    public MeatTypes getType() {
        return requiredType;
    }

    public synchronized   void addMeat(Meat meat){
        System.out.println("meat is added " + requiredType);
        meats.add(meat);
        notifyAll();
    }

    public boolean isEmpty(){
        return this.meats.isEmpty();
    }

    public synchronized void takeMeat(){
        while (isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        this.meats.poll();
    }
}
