package creator.builder;

/**
 * Created by single on 17/3/31.
 */
public class Client {
    public static void main(String[] args) throws NoSuchFieldException {

        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.constrct();
        Product product = builder.retrieveProduct();
        System.out.print(product);
    }
}
