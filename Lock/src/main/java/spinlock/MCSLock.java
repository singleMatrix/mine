package spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author single
 * @date 2017/10/20.
 */
public class MCSLock implements Lock {

    private AtomicReference<QNode> tail;

    ThreadLocal<QNode> myNode;

    public MCSLock(){
        tail = new AtomicReference<QNode>(null);
        myNode = new ThreadLocal<QNode>(){
            protected QNode initialValue(){
                return new QNode();
            }
        };
    }

    @Override
    public void lock() {
        QNode node = myNode.get();
        QNode preNode = tail.getAndSet(node);
        if(preNode != null){
            node.lock = true;
            preNode.next = node;
            while(node.lock){

            }
        }
    }

    @Override
    public void unlock() {
        QNode node = myNode.get();
        if(node.next == null){
            if(tail.compareAndSet(node, null)){
                return;
            }
            while(node.next == null){

            }
        }
        node.next.lock = false;
        node.next = null;
    }

    public static class QNode {
        volatile boolean lock;
        volatile QNode next;
    }
}
