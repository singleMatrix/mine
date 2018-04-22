package spinlock;

import sun.security.x509.AVA;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.*;

/**
 * @author single
 * @date 2017/10/20.
 */
public class TimeoutLock implements java.util.concurrent.locks.Lock {

    private static final QNode AVAILABLE = new QNode();

    private AtomicReference<QNode> tail;

    ThreadLocal<QNode> myNode;

    public TimeoutLock() {
        tail = new AtomicReference<>(null);
        myNode = new ThreadLocal<QNode>() {
            @Override
            protected QNode initialValue() {
                return new QNode();
            }
        };
    }

    @Override
    public void lock() {
        QNode node = new QNode();
        myNode.set(node);
        QNode pre = tail.getAndSet(node);
        if (pre != null) {
            while (pre.preNode != AVAILABLE) {

            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        boolean isInterrupted = false;
        long startTime = System.currentTimeMillis();
        long duration = TimeUnit.MICROSECONDS.convert(time, unit);

        QNode node = new QNode();
        myNode.set(node);
        QNode pre = tail.getAndSet(node);
        if (pre == null || pre == AVAILABLE) {
            return true;
        }

        while ((System.currentTimeMillis() - startTime < duration) && !isInterrupted) {
            QNode prePreNode = pre.preNode;
            if (prePreNode == AVAILABLE) {
                return true;
            } else if (prePreNode != null) {
                pre = prePreNode;
            }
            if(Thread.interrupted()){
                isInterrupted = true;
            }
        }
        node.preNode = pre;
        if(isInterrupted){
            throw new InterruptedException();
        }
        return false;
    }

    @Override
    public void unlock() {
        QNode node = myNode.get();
        if (!tail.compareAndSet(node, null)) {
            node.preNode = AVAILABLE;
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static class QNode {
        volatile QNode preNode;
    }
}
