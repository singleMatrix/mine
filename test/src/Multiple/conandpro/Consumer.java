package Multiple.conandpro;

/**
 * Created by single on 17/3/22.
 */
public class Consumer implements Runnable{
    private Monkey monkey;

    Consumer(Monkey monkey) {
        this.monkey = monkey;
    }

    private void consume(Monkey mon){
        synchronized (mon){
            if(mon.getNum() <= 0){
                try {
                    System.out.println(Thread.currentThread().getName() + "--");
                    mon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            mon.give();
            System.out.println(Thread.currentThread().getName() + " - 1");
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
        while (i-- > 0){
            consume(monkey);
        }
    }
}
