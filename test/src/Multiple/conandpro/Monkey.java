package Multiple.conandpro;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by single on 17/3/22.
 */
public class Monkey {
    public static final int MAX_SIZE = 2;
    private Queue<Apple> bag = new LinkedList<>();

    public void give(){
        bag.remove();
    }

    public void catcha(Apple apple){
        bag.offer(apple);
    }

    public int getNum(){
        return bag.size();
    }

    public Boolean isFull(){
        return bag.size() >= 2;
    }

    public static void main(String[] args){
        Monkey monkey = new Monkey();
        Consumer c1 = new Consumer(monkey);
        Consumer c2 = new Consumer(monkey);
        Thread ct1 = new Thread(c1);
        Thread ct2 = new Thread(c2);

        Producer p1 = new Producer(monkey);
        Producer p2 = new Producer(monkey);
        Thread pt1 = new Thread(p1);
        Thread pt2 = new Thread(p2);

        ct2.start();
        ct1.start();
        pt1.start();
        pt2.start();

    }
}
