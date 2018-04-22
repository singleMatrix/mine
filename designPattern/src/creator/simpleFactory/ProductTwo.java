package creator.simpleFactory;

/**
 * Created by single on 17/3/30.
 */
public class ProductTwo implements Product{
    ProductTwo(){
        System.out.println("product two has been created!");
    }
    @Override
    public void doSomething() {
        System.out.println("Product two do something!");
    }
}
