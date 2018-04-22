import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by single on 17/3/6.
 */
public class MallTest {
    public static void main(String[] args){
        List<Mall> malls = new ArrayList<>();
        malls.add(new Mall(1l, "1"));
        malls.add(new Mall(0l, "0"));
        malls.add(new Mall(5l, "5"));
        malls.add(new Mall(4l, "4"));
        malls.add(new Mall(3l, "3"));

       // malls.sort();
    }
}
