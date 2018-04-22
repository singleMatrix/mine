package creator.singleton;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by single on 17/3/31.
 */
public class Singleton {
    private static volatile Singleton single;

    private Singleton() {

    }

    public static void main(String[] args) {
        try {
            //LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
            // queue.put("Sgrig");
            ConcurrentLinkedQueue<String> queue1 = new ConcurrentLinkedQueue<>();
            queue1.add("String");
        } catch (Exception e) {

        }
    }

    public static Singleton createInstance() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }

}
