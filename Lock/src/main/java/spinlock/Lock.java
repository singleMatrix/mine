package spinlock;

/**
 * @author single
 * @date 2017/10/17.
 */
public interface Lock {
    void lock();

    void unlock();
}
