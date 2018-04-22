package spinlock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author single
 * @date 2017/10/17.
 */
public class BackOff {

    private final int minDelay, maxDelay;
    private int limit;
    private final Random random;

    public BackOff(int minDelay, int maxDelay) {
        this.minDelay = minDelay;
        this.maxDelay = maxDelay;
        limit = minDelay;
        this.random = new Random();
    }

    public void backoff() throws InterruptedException{
        int delay = random.nextInt(limit);
        limit = Math.min(maxDelay, 2 * limit);
        Thread.sleep(delay);
    }
}
