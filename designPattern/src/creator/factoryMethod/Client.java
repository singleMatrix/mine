package creator.factoryMethod;

/**
 * Created by single on 17/3/30.
 */
public class Client {
    public static void main(String[] args){
        Factory factory = new FactoryOne();
        Product product = factory.create();
        product.doSomething();
    }
}
