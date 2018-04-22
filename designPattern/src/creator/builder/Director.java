package creator.builder;

/**
 * Created by single on 17/3/31.
 */
public class Director {
    private Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }

    public void constrct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}
