package main.foods.bread;

public class WholeGrainBread extends Bread{
    @Override
    public int getTimeToPrepare() {
        return 5000;
    }

    @Override
    public double getPrice() {
        return 1.4;
    }
}
