package main.foods.meat;

public class Steak extends Meat {
    @Override
    public int getTimeToPrepare() {
        return 4000;
    }

    @Override
    public double getPrice() {
        return 3;
    }
}
