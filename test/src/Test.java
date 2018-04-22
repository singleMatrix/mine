import java.io.*;
import java.util.concurrent.*;

/**
 * Created by single on 16/8/12.
 */
public class Test {
    public static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String args[]) {
        CountDownLatch latch = new CountDownLatch();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/liyajun/Desktop/20180313gjuidmobile1.txt")));
            BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/liyajun/Desktop/ganjiuidmobile.txt")));

            Integer a = new Integer(10);
            a.equals()

            while(true) {
                String line = reader.readLine();
                if(line== null || line.equals("")){
                    writer.flush();
                    break;
                }
                String[] lines = line.split("\t");
                Long uid = Long.parseLong(lines[0]);
                Long mobile = Long.parseLong(lines[1]);
                writer.write(uid + "|" + mobile + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
