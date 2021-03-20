import main.BBQ;
import main.Order;
import main.utensils.requiredTypes.BreadsTypes;
import main.utensils.requiredTypes.MeatTypes;
import main.utensils.requiredTypes.SaladTypes;

public class Demo {
    public static void main(String[] args) {
        BBQ bbq = new BBQ();
        bbq.makeOrder(new Order(MeatTypes.KIUFTE, BreadsTypes.WHITE_BREAD, SaladTypes.LIUTENITSA));
        bbq.start();
        bbq.startCashier();
    }
}
