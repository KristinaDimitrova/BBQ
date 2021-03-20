package main.utensils;

import main.foods.bread.Bread;
import main.utensils.requiredTypes.BreadsTypes;

import java.util.LinkedList;
import java.util.Queue;


public class BreadPan extends Utensil {
    private Queue<Bread> breads;
    private static final int CAPACITY = 30;
    private BreadsTypes requiredType;

    public BreadPan(BreadsTypes requiredType) {
        breads = new LinkedList<>();
        this.requiredType = requiredType;
    }

    @Override
    public boolean isFull() {
        return  breads.size() >= CAPACITY;
    }


    public BreadsTypes getType() {
        return requiredType;
    }

    public synchronized void addBread(Bread bread){
        breads.add(bread);
        System.out.println("bread is added" + requiredType);
        notifyAll();
    }

    public boolean isEmpty(){
        return this.breads.isEmpty();
    }

    public synchronized void takeBread(){
        while (isEmpty()) {
                try {
                   wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        this.breads.poll();
    }
}