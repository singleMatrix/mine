package Multiple.conandpro;

/**
 * Created by single on 17/3/22.
 */
public class Plate {
    int apple = 0;

    public synchronized void put() {
        int i = 10;
        while (i-- > 0) {
            while (apple == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            apple = 1;
            System.out.println(Thread.currentThread().getName() + " + 1");
            notifyAll();
        }
    }

    public synchronized void get() {
        int i = 10;
        while (i-- > 0) {
            while (apple == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            apple = 0;
            System.out.println(Thread.currentThread().getName() + " - 1");
            notifyAll();
        }
    }

    public static void main(String[] args){
        Plate plate = new Plate();
        new Thread(()-> {
                plate.put();
        }).start();

        new Thread(()->{
                plate.put();
        }).start();

        new Thread(()-> {
                plate.get();
        }).start();

        new Thread(()->{
                plate.get();
        }).start();
    }
}
