package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 选择排序,不稳定
 *
 * @author single
 * @date 2018/1/5.
 */
public class QuickSortWithOutRecursion implements ISort {
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    private Queue<Map<Integer, Integer>> queue = new LinkedBlockingQueue<Map<Integer, Integer>>();

    public int[] sort(int[] source) {
        this.addStack(0, source.length - 1);

        Map<Integer, Integer> param = queue.poll();
        while (param != null) {
            this.recursion(source, param.get(1), param.get(2));
            param = queue.poll();
        }
        return source;
    }

    private void recursion(int[] source, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int start = startIndex;
        int end = endIndex;
        while (start < end) {
            COMPARE_COUNT++;
            while (end > start) {
                COMPARE_COUNT++;
                if (source[end] > source[start]) {
                    EXCHANGE_COUNT++;
                    SortUtils.exchange(source, end, start);
                    start++;
                    break;
                }
                end--;
            }

            COMPARE_COUNT++;
            while (start < end) {
                COMPARE_COUNT++;
                if (source[start] < source[end]) {
                    EXCHANGE_COUNT++;
                    SortUtils.exchange(source, start, end);
                    end--;
                    break;
                }
                start++;
            }
        }

        this.addStack(startIndex, start - 1);
        this.addStack(start + 1, endIndex);
    }

    private void addStack(int start, int end) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, start);
        map.put(2, end);
        queue.add(map);
    }

    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
