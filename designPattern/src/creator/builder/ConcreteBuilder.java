package creator.builder;

import java.io.Serializable;

/**
 * Created by single on 17/3/31.
 */
public class ConcreteBuilder implements Builder, Cloneable, Serializable {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("build product part 1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("build product part 2");
    }

    @Override
    public Product retrieveProduct() {
        return product;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
