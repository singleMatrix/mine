/**
 * Created by single on 17/4/2.
 */
public class TestCache {
    private static final int RUNS = 10;
    private static final int DIMENSION_1 = 1024 * 1024;
    private static final int DIMENSION_2 = 62;

    private static long[][] longs;

    public static void main(String[] args) throws InterruptedException {
        longs = new long[DIMENSION_1][];
        for (int i = 0; i < DIMENSION_1; i++) {
            longs[i] = new long[DIMENSION_2];
            for (int j = 0; j < DIMENSION_2; j++) {
                longs[i][j] = 0l;
            }
        }

        System.out.println("starting...");
        long startTime = System.nanoTime();
        long sum = 0l;
        for (int i = 0; i < DIMENSION_1; i++) {
            for (int j = 0; j < DIMENSION_2; j++) {
                sum += longs[i][j];
            }
        }
        System.out.println("duration = " + (System.nanoTime() - startTime));


        startTime = System.nanoTime();
        for (int j = 0; j < DIMENSION_2; j++) {
            for (int i = 0; i < DIMENSION_1; i++) {
                sum += longs[i][j];
            }
        }

        System.out.println("duration = " + (System.nanoTime() - startTime));
    }
}
