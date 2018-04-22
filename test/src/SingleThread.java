import java.util.concurrent.*;

/**
 * Created by single on 17/3/17.
 */
public class SingleThread {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(() -> {
            Future<Integer> getOne, getTwo;
            getOne = es.submit(() ->
                            System.out.println("I am the Thread one, but I will not show because of thread dead")
                    , 23);

            getTwo = es.submit(() ->
                            System.out.println("I am the Thread two, but I will not show because of thread dead")
                    , 28);

            try {
                int sum = getOne.get(10, TimeUnit.SECONDS) + getTwo.get(20, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                /*e.printStackTrace();
                if(getOne.isCancelled()){
                    System.out.println("get one canceled");
                } else {
                    getOne.cancel(true);
                    getTwo.cancel(true);
                }*/
                System.out.println("all is over");
            } finally {
                es.shutdownNow();
            }
        });
    }
}
