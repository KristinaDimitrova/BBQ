package main.foods.salad;

public class RussianSalad extends Salad {
    @Override
    public int getTimeToPrepare() {
        return 10000;
    }

    @Override
    public double getPrice() {
        return 1.5;
    }
}
