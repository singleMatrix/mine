package spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author single
 * @date 2017/10/17.
 */
public class CLHLock implements Lock{
    private AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;
    ThreadLocal<QNode> myPreNode;

    public CLHLock(){
        tail = new AtomicReference<QNode>(new QNode());
        myNode = new ThreadLocal<QNode>(){
            protected QNode initialValue(){
                return new QNode();
            }
        };

        myPreNode = new ThreadLocal<QNode>(){
            protected QNode initialValue(){
                return null;
            }
        };
    }

    @Override
    public void lock() {
        QNode node = myNode.get();
        node.lock = true;

        QNode preNode = tail.getAndSet(node);
        myPreNode.set(preNode);
        while (preNode.lock){

        }
    }

    @Override
    public void unlock() {
        QNode node = myNode.get();
        node.lock = false;
        myNode.set(myPreNode.get());
    }

    public static class QNode {
        volatile boolean lock;
    }

    public String toString(){
        return "CLHLock";
    }
}
