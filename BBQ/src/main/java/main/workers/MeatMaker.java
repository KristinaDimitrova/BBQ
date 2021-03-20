package main.workers;

import main.BBQ;

public class MeatMaker  extends  Thread{

    private BBQ bbq;

    public MeatMaker(BBQ bbq) {
        this.bbq = bbq;
    }

    @Override
    public void run() {
        while (true){
            bbq.addMeat();
        }
    }
}
