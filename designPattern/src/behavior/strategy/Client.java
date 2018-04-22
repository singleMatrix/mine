package behavior.strategy;

/**
 * Created by single on 17/4/6.
 */
public class Client {
    public static void main(String[] args){
        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.execute();
    }
}
