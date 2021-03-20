package main.foods.meat;

public class Pleskavitsa  extends Meat{
    @Override
    public int getTimeToPrepare() {
        return 3000;
    }

    @Override
    public double getPrice() {
        return 2.0;
    }
}
