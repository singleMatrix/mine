package com.single.mine.sortdemo;

import com.single.mine.sortdemo.impl.HeapSort;
import com.single.mine.sortdemo.impl.MergeSort;
import com.single.mine.sortdemo.utils.SortUtils;
import com.sun.tools.javac.util.Assert;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author single
 * @date 2018/1/3.
 */
public class Executor {
    public static void main(String[] args) {
        ThreadPoolExecutor es = Executors.newCachedThreadPool();
        es.submit()

        int num = 20;
        int[] source = getList(num);
        SortUtils.printArray("init  array:", source);

        ISort sort = new HeapSort();

        int[] result = sort.sort(source);

        SortUtils.printArray("final Array:", result);
        Assert.check(validate(result));
        System.out.println("LIST NUM:" + num);
        System.out.println("COMPARE  COUNT:" + sort.getCompareCount());
        System.out.println("EXCHANGE COUNT:" + sort.getExchangeCount());
    }

    public static int[] getList(int num) {
        final Random random = new Random();
        int[] source = new int[num];

        for (int i = 0; i < num; i++) {
            source[i] = random.nextInt(5 * num);
        }
        return source;
    }

    public static Boolean validate(int[] list) {
        if (list.length < 2) {
            return false;
        }

        Boolean incr = true;
        for (int i = 0; i < list.length - 1; i++) {
            int gap = list[i + 1] - list[i];
            if (gap < 0) {
                incr = false;
                break;
            }
        }
        if (incr) {
            return true;
        }

        Boolean decr = true;
        for (int i = 0; i < list.length - 1; i++) {
            int gap = list[i + 1] - list[i];
            if (gap > 0) {
                decr = false;
                break;
            }
        }
        if (decr) {
            return true;
        }
        return false;
    }
}
