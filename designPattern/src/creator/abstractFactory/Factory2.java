package creator.abstractFactory;

/**
 * Created by single on 17/3/30.
 */
public class Factory2 implements Factory{
    @Override
    public ProductA createA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createB() {
        return new ConcreteProductB2();
    }
}
