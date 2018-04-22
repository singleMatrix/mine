import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by single on 17/3/12.
 */
public class Pair<K, V, N> {
    public static void main(String[] args) {
        List<String> ss = Arrays.asList("e q et d d t u f s".split(" "));
        Collection<String> s = new ArrayList<>(0);
        s.add("a");
        s.add(null);
        s.add(null);
        System.out.println(s.size());
        int i = 10;
        int j = i >> 1;
        System.out.println(j);
    }
}
