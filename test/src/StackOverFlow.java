import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by single on 17/3/17.
 */
public class StackOverFlow {
    public static void main(String[] args) {
        int i;
        Queue<int[]> queue = new LinkedList<int[]>();
        while (true) {
            StackOverFlow sof = new StackOverFlow();
            int[] tmp = sof.new A().execute();
            if (queue.size() > 1000) {
                //System.out.println(queue.size());
                queue.poll();
            } else {
                //System.out.println(queue.size());
                queue.offer(tmp);
            }
        }
    }


    class A {
        int[] storage = new int[102400];
        int[] extra = new int[200000];

        public int[] execute() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return storage;
        }

    }


    public static void overFlow() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("max memory:" + runtime.maxMemory() / (1024 * 1024));
        System.out.println("free memory:" + runtime.freeMemory() / (1024 * 1024));
        System.out.println("total memory:" + runtime.totalMemory() / (1024 * 1024));

        StringBuilder sb = new StringBuilder("a");
        int i = 0;
        while (true) {
            if (i == 27) {
                runtime.gc();
            }
            System.out.println(sb.length() * 2 / (1024 * 1024));
            System.out.println("max memory:" + runtime.maxMemory() / (1024 * 1024));
            System.out.println("free memory:" + runtime.freeMemory() / (1024 * 1024));
            System.out.println("used memory:" + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
            /*if (i++ == 28) {
                try {
                    Thread.sleep(1000 * 10);
                    sb = new StringBuilder("b");
                    System.out.println("max memory:" + runtime.maxMemory() / (1024 * 1024));
                    System.out.println("free memory:" + runtime.freeMemory() / (1024 * 1024));
                    System.out.println("total memory:" + runtime.totalMemory() / (1024 * 1024));
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            sb.append(sb);
        }
    }
}
