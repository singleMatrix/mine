package test4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author single
 * @date 2017/6/18.
 */
public class FileHeap {
    static class OOMObject {
        public byte[] palceHolder = new byte[64 * 1024];

    }

    public static void fileHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i =0; i < num; i ++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fileHeap(1000);
        System.gc();
        System.out.println("over");
    }
}
