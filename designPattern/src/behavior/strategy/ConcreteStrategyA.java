package behavior.strategy;

/**
 * Created by single on 17/4/6.
 */
public class ConcreteStrategyA implements Strategy{
    @Override
    public void doThing() {
        System.out.println("Strategy A do Thing");
    }
}
