package Multiple;

/**
 * Created by single on 17/3/22.
 */
public class TestJoin implements Runnable {

    public static int TAG = 0;

    @Override
    public void run() {
        TAG ++;
        System.out.println("tag = " + TAG);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Do Something:" + TAG);
    }

    public static void main(String[] args) {
        TestJoin test = new TestJoin();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}