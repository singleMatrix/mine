package creator.builder;

import java.io.Serializable;

/**
 * Created by single on 17/3/31.
 */
public class Product implements Serializable{
    private String part1;

    private String part2;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString(){
        return this.getPart1() + "\r\n" + this.getPart2();
    }
}
