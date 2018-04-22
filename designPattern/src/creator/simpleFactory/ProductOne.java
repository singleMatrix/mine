package creator.simpleFactory;

/**
 * Created by single on 17/3/30.
 */
public class ProductOne implements Product{
    ProductOne(){
        System.out.println("product one has been created!");
    }

    @Override
    public void doSomething() {
        System.out.println("Product one do something!");
    }
}
