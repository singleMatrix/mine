package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;

/**
 * @author single
 * @date 2018/1/4.
 */
public class InsertSort implements ISort {
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            doSort(source, i);
        }
        return source;
    }

    private void doSort(int[] source, int endIndex) {
        int temp = source[endIndex];
        int end = endIndex;
        for (int i = endIndex - 1; i >= 0; i--) {
            COMPARE_COUNT++;
            EXCHANGE_COUNT++;
            if (temp > source[i]) {
                end = i;
                source[i + 1] = source[i];
            } else {
                break;
            }
        }
        source[end] = temp;
    }

    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
