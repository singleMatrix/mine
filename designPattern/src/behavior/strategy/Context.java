package behavior.strategy;

/**
 * Created by single on 17/4/6.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doThing();
    }
}
