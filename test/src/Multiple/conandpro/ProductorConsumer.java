package Multiple.conandpro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author single
 * @date 2018/1/11.
 */
public class ProductorConsumer {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;
        Thread producer = new Xroducer(queue, maxSize, "producer1");
        Thread consumer = new Xonsumer(queue, maxSize, "consumer1");

        Thread producer2 = new Xroducer(queue, maxSize, "producer2");
        Thread producer3 = new Xroducer(queue, maxSize, "producer3");
        Thread producer4 = new Xroducer(queue, maxSize, "producer4");
        Thread consumer2 = new Xonsumer(queue, maxSize, "consumer2");

        producer.start();
        consumer.start();

        producer2.start();
        consumer2.start();

        producer3.start();
        producer4.start();
    }
}

class Xroducer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Xroducer(Queue<Integer> queue, int maxsize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxsize;
    }


    @Override
    public void run() {

        synchronized (queue) {
            while (true) {
                while (queue.size() == maxSize) {
                    System.out.println(Thread.currentThread().getName() + "full-----");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                int i = random.nextInt();
                queue.add(i);
                queue.notifyAll();
                System.out.println(Thread.currentThread().getName() + "producing one---" + i);
            }
        }
    }
}


class Xonsumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Xonsumer(Queue<Integer> queue, int maxsize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxsize;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {

                while (queue.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + "empty-----");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int i = queue.remove();
                queue.notifyAll();
                System.out.println(Thread.currentThread().getName() + "consumer one---" + i);
            }
        }
    }
}

