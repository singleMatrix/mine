package creator.factoryMethod;

/**
 * Created by single on 17/3/30.
 */
public class FactoryOne implements Factory{
    @Override
    public Product create() {
        return new ProductOne();
    }
}
