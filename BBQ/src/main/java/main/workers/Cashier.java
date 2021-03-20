package main.workers;

import com.google.gson.Gson;
import main.BBQ;
import main.Order;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cashier extends  Thread{

    private BlockingQueue<Order> orders;
    private BBQ bbq;
    private TreeSet<Order> ordersArchive;


    public Cashier( BBQ bbq) {
        this.orders = new LinkedBlockingQueue<>();
        this.bbq = bbq;
        ordersArchive = new TreeSet<>(((o1, o2) -> o1.getTime().compareTo(o2.getTime())));
    }

    public void addNewOrder(Order o){
        System.out.println("new order was added");
        orders.add(o);
    }

    private void serveCustomer(){

        Order o = orders.poll();
        if(o != null){
            System.out.println("serving was started");
            bbq.getSalad(o);
            bbq.getBread(o);
            bbq.getMeat(o);
            o.setLocalDateTime(LocalDateTime.now());
            ordersArchive.add(o);
            System.out.println(o + " was completed");
        }
    }

    @Override
    public void run() {
       while (true){
          serveCustomer();
       }
    }

    public TreeSet<Order> getOrdersArchive() {
        return ordersArchive;
    }
}
