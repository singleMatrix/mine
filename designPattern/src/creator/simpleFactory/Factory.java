package creator.simpleFactory;

/**
 * Created by single on 17/3/30.
 *
 * 简单工厂将对象的创建过程
 */
public class Factory {
    public static Product createProduct(int type) {
        if (type == 1) {
            return new ProductOne();
        } else {
            return new ProductTwo();
        }
    }

    public static void main(String[] args) {
        Product product = Factory.createProduct(1);
    }
}
