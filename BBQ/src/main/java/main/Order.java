package main;

import main.utensils.requiredTypes.BreadsTypes;
import main.utensils.requiredTypes.MeatTypes;
import main.utensils.requiredTypes.SaladTypes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private MeatTypes meat;
    private BreadsTypes bread;
    private SaladTypes salad;
    private double price;
    private LocalDateTime localDateTime;

    public Order(MeatTypes meat, BreadsTypes bread, SaladTypes salad) {
        this.meat = meat;
        this.bread = bread;
        this.salad = salad;
    }

    public MeatTypes getMeatType() {
        return meat;
    }

    public BreadsTypes getBreadType() {
        return bread;
    }

    public SaladTypes getSaladType() {
        return salad;
    }

    public void setPrice(double price) {
        this.price += price;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getTime() {
        return localDateTime.toString();
    }

    @Override
    public String toString() {
        return meat + " in " + bread + " with " + salad + ", " + price + ", " + localDateTime ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 && meat == order.meat && bread == order.bread && salad == order.salad && Objects.equals(localDateTime, order.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meat, bread, salad, price, localDateTime);
    }
}
