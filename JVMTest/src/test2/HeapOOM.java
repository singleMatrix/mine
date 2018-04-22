package test2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author single
 * @date 2017/6/11.
 */
public class HeapOOM {
	/**
	 * VMArgs: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
	 * @author liyajun
	 *
	 */
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
