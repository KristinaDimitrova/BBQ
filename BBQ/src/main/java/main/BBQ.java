package main;

import main.foods.bread.Bread;
import main.foods.bread.WhiteBread;
import main.foods.bread.WholeGrainBread;
import main.foods.meat.Kiufte;
import main.foods.meat.Meat;
import main.foods.meat.Pleskavitsa;
import main.foods.meat.Steak;
import main.foods.salad.*;
import main.utensils.Bowl;
import main.utensils.BreadPan;
import main.utensils.Pot;
import main.utensils.requiredTypes.BreadsTypes;
import main.utensils.requiredTypes.MeatTypes;
import main.utensils.requiredTypes.SaladTypes;
import main.workers.BreadMaker;
import main.workers.Cashier;
import main.workers.MeatMaker;
import main.workers.SaladMaker;
import java.util.ArrayList;
import java.util.Random;

public class BBQ {
    private BreadMaker breadMaker;
    private MeatMaker meatMaker;
    private SaladMaker saladMaker;
    private ArrayList<Bowl> saladBowls = new ArrayList<>();
    private ArrayList<BreadPan> breadPans = new ArrayList<>();
    private ArrayList<Pot> meatPots = new ArrayList<>();
    private Cashier cashier;

    public  BBQ(){
        saladBowls.add(new Bowl(SaladTypes.RUSSIAN_SALAD));
        saladBowls.add(new Bowl(SaladTypes.SNOW_WHITE_SALAD));
        saladBowls.add(new Bowl( SaladTypes.LIUTENITSA));
        saladBowls.add(new Bowl(SaladTypes.TOMATOES_AND_CUCUMBER));
        saladBowls.add(new Bowl( SaladTypes.CABBAGE_AND_CARROTS));
        breadPans.add(new BreadPan(BreadsTypes.WHITE_BREAD));
        breadPans.add(new BreadPan(BreadsTypes.WHOLE_GRAIN_BREAD));
        meatPots.add(new Pot(MeatTypes.KIUFTE));
        meatPots.add(new Pot (MeatTypes.PLESKAVITSA));
        meatPots.add(new Pot(MeatTypes.STEAK));
        breadMaker = new BreadMaker(this);
        meatMaker = new MeatMaker(this);
        saladMaker = new SaladMaker(this);
        cashier = new Cashier(this);
    }

    public void start(){
        saladMaker.start();
        meatMaker.start();
        breadMaker.start();
    }

    public void startCashier(){
        cashier.start();
    }

    public void addMeat(){
            Pot meatPot;
            int r = 0;
            do{
                r = new Random().nextInt(meatPots.size());
            }while (meatPots.get(r).isFull());
            meatPot = meatPots.get(r);
            Meat m = null;
            switch (meatPot.getType()){
                case KIUFTE -> m = new Kiufte();
                case PLESKAVITSA-> m = new Pleskavitsa();
                case STEAK -> m = new Steak();
            }
            meatPot.addMeat(m);
            meatPot.setItemsPrice(m.getPrice());
            try {
                Thread.sleep(m.getTimeToPrepare());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public  void addSalad(){
            Bowl saladBowl;
            int r = 0;
            do{
                r = new Random().nextInt(saladBowls.size());
            }while (saladBowls.get(r).isFull());
            saladBowl= saladBowls.get(r);
            Salad s = null;
            switch (saladBowl.getType()){
                case  RUSSIAN_SALAD -> s = new RussianSalad();
                case LIUTENITSA-> s = new Liutenitsa();
                case SNOW_WHITE_SALAD-> s = new SnowWhiteSalad();
                case TOMATOES_AND_CUCUMBER -> s = new TomatoesAndCucumbers();
                case CABBAGE_AND_CARROTS -> s = new CabbageAndCarrots();
            }
            saladBowl.setItemsPrice(s.getPrice());
            saladBowl.addSalad(500);
            try {
                Thread.sleep(s.getTimeToPrepare());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public  void addBread(){

            BreadPan breadPan;
            int r = 0;
            do{
                r = new Random().nextInt(breadPans.size());
            }while (breadPans.get(r).isFull());
            breadPan = breadPans.get(r);

            Bread b = null;
            switch ( breadPan.getType()){
                case WHITE_BREAD -> b= new WhiteBread();
                case WHOLE_GRAIN_BREAD -> b = new WholeGrainBread();
            }
            breadPan.setItemsPrice(b.getPrice());
            breadPan.addBread(b);
            try {
                Thread.sleep(b.getTimeToPrepare());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void getSalad ( Order o){
        synchronized (saladBowls){
            Bowl bowl = null;
            for(Bowl b : saladBowls){
                if (b.getType().equals(o.getSaladType())){
                    bowl = b;
                }
            }
            bowl.takeSalad();
            o.setPrice(bowl.getItemsPrice());
        }
    }

    public  void getMeat(Order o) {
            Pot pot = null;
            for (Pot p : meatPots) {
                if (p.getType().equals(o.getMeatType())) {
                    pot = p;
                }
            }
            pot.takeMeat();
            o.setPrice(pot.getItemsPrice());
    }

    public  void getBread( Order o){
        synchronized(breadPans) {
            BreadPan pan = null;
            for (BreadPan breadPan : breadPans) {
                if (breadPan.getType().equals( o.getBreadType())) {
                    pan = breadPan;
                }
            }
            pan.takeBread();
            o.setPrice(pan.getItemsPrice());
        }
    }

    public void makeOrder(Order o){
        cashier.addNewOrder(o);
    }
}
