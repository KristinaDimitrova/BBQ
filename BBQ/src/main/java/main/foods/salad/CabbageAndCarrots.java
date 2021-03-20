package main.foods.salad;

public class CabbageAndCarrots extends Salad {
    @Override
    public int getTimeToPrepare() {
        return 2000;
    }

    @Override
    public double getPrice() {
        return 0.8;
    }
}
