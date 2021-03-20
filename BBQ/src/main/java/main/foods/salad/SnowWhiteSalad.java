package main.foods.salad;

public class SnowWhiteSalad extends Salad{
    @Override
    public int getTimeToPrepare() {
        return 4000;
    }

    @Override
    public double getPrice() {
        return 1.2;
    }
}
