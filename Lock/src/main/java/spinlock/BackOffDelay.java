package spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author single
 * @date 2017/10/17.
 */
public class BackOffDelay implements Lock{

    private final int MIN_DELAY, MAX_DELAY;

    public BackOffDelay(int min, int max){
        MIN_DELAY = min;
        MAX_DELAY = max;
    }

    private AtomicBoolean mutex = new AtomicBoolean(false);

    @Override
    public void lock() {
        BackOff backOff = new BackOff(MIN_DELAY, MAX_DELAY);
        while (true){
            while(mutex.get()){
                if(!mutex.getAndSet(true)){
                    return;
                }else{
                    try{
                        backOff.backoff();
                    } catch (InterruptedException e){

                    }
                }
            }
        }
    }

    @Override
    public void unlock() {
        mutex.set(false);
    }

    public String toString(){
        return "TTASLock";
    }
}
