package javanet;

import java.util.concurrent.Executors;

/**
 * Created by single on 17/3/8.
 */
public class MultiThread {

    public static void main(String[] args){
        String a = new String("a");
        String b = "a";
        System.out.print(a.intern() == b);

    }
}

class InnerClass {
    public void doSomething(){
        System.out.println("2");
        try {
            Thread.sleep(10000);
            System.out.println("4");
        } catch (InterruptedException e) {
        }
    }

    public void dothing(){
        System.out.println("3");
    }
}