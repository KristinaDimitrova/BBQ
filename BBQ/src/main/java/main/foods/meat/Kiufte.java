package main.foods.meat;

public class Kiufte extends Meat
{
    @Override
    public int getTimeToPrepare() {
        return 2000;
    }

    @Override
    public double getPrice() {
        return 1.0;
    }
}
