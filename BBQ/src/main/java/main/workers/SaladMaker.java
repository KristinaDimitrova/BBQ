package main.workers;

import main.BBQ;

public class SaladMaker  extends Thread{
    private BBQ bbq;

    public SaladMaker(BBQ bbq) {
        this.bbq = bbq;
    }

    @Override
    public void run() {
       while (true){
           bbq.addSalad();
       }
    }
}
