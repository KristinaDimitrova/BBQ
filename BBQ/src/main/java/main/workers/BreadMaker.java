package main.workers;

import main.BBQ;

public class BreadMaker extends  Thread{

    private BBQ bbq;

    public BreadMaker(BBQ bbq) {
        this.bbq = bbq;
    }

    @Override
    public void run() {
        while (true){
            bbq.addBread();
        }
    }
}
