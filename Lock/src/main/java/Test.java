import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author single
 * @date 2017/10/22.
 */
public class Test {
    public static final int MAX = 10000000;
    static class Tag{
        public  boolean[] tags = new boolean[MAX];
    }
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        readLock.tryLock();
        readLock.lock();


        final Tag tag = new Tag();
        Thread t = new Thread(() -> {
            int i = 0;
            while (true) {
                if(tag.tags[i]){
                    if(++i == MAX){
                        System.out.println(i);
                        break;
                    }
                }
            }
            System.out.println(System.currentTimeMillis());
            System.out.println();
        });
        t.start();
        for(int i = 0; i < MAX; i ++) {
            tag.tags[i] = true;
        }
        System.out.println(System.currentTimeMillis());
    }
    
}
