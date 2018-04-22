/**
 * Created by single on 17/4/4.
 */
public class TestVolatile {
    private int a = 1;
    private int b = 1;

    void change() {
        a = 3;
        b = 3;
    }

    void printf() {
        System.out.println(a + "" + b);
    }

    public static void main(String[] args) {
        int i = 0;
        while (i++ < 100) {
            final TestVolatile testVolatile = new TestVolatile();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        testVolatile.change();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        testVolatile.printf();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
