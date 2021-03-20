package main.foods.bread;

public class WhiteBread extends Bread{
    @Override
    public int getTimeToPrepare() {
        return 2000;
    }

    @Override
    public double getPrice() {
        return 0.9;
    }
}
