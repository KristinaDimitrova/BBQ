package main.foods.salad;

public class Liutenitsa extends Salad {
    @Override
    public int getTimeToPrepare() {
        return 8000;
    }

    @Override
    public double getPrice() {
        return 1.1;
    }
}
