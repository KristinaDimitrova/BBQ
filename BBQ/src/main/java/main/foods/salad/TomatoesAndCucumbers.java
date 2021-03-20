package main.foods.salad;

public class TomatoesAndCucumbers extends Salad {
    @Override
    public int getTimeToPrepare() {
        return 3000;
    }

    @Override
    public double getPrice() {
        return 1.3;
    }
}
