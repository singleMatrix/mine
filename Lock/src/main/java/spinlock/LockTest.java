package spinlock;

/**
 * @author single
 * @date 2017/10/17.
 */
public class LockTest {
    private static TASLock tasLock = new TASLock();

    private static int n = 0;

    public static void method() {
        tasLock.lock();
        System.out.println("n : " + ++n);
        System.out.println("n : " + ++n);
        System.out.println("n : " + ++n);
        System.out.println("n : " + ++n);
        System.out.println("n : " + ++n);
        tasLock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> method());
            thread.start();
        }
    }
}
