package Multiple.conandpro;

/**
 * Created by single on 17/3/22.
 */
public class Producer implements Runnable{
    private Monkey monkey;

    Producer(Monkey monkey){
        this.monkey = monkey;
    }

    private void produce(Monkey mon){
        synchronized (mon){
            if(mon.isFull()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "--");
                    mon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            mon.catcha(new Apple());
            System.out.println(Thread.currentThread().getName() + " + 1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mon.notifyAll();
        }
    }

    @Override
    public void run() {
        int i = 4;
        while(i-- > 0){
            produce(monkey);
        }
    }
}
