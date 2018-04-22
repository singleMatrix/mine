package creator.abstractFactory;

/**
 * Created by single on 17/3/30.
 */
public class Client {
    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        ProductA productA = factory1.createA();
        productA.doSomething();
    }
}
